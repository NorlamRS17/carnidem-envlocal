package ec.com.sidesoft.imports.ad_process;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.openbravo.base.exception.OBException;
import org.openbravo.base.session.OBPropertiesProvider;
import org.openbravo.dal.core.OBContext;
import org.openbravo.dal.service.OBCriteria;
import org.openbravo.dal.service.OBDal;
import org.openbravo.erpCommon.utility.OBError;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.model.ad.access.User;
import org.openbravo.model.ad.datamodel.Table;
import org.openbravo.model.ad.utility.Attachment;
import org.openbravo.model.common.order.Order;
import org.openbravo.model.common.order.OrderLine;
import org.openbravo.model.common.plm.Product;
import org.openbravo.scheduling.ProcessBundle;
import org.openbravo.service.db.DalBaseProcess;

import au.com.bytecode.opencsv.CSVReader;

public class UpdateFOB extends DalBaseProcess {
	private final Logger log4j = Logger.getLogger(UpdateFOB.class);

	final String attachPath = OBPropertiesProvider.getInstance().getOpenbravoProperties().getProperty("attach.path");
	final String tableId = "259"; // c_order
	final String dataType = "text/csv";
	Order order;

	@Override
	public void doExecute(ProcessBundle bundle) throws Exception {
		OBError msg = new OBError();
		msg.setType("Success");
		msg.setTitle("Carga de datos");

		OBContext.setAdminMode(true);

		try {
			String recordId = (String) bundle.getParams().get("C_Order_ID");
			System.out.println(recordId);

			process(recordId);
			OBDal.getInstance().commitAndClose();
		} catch (final Exception e) {
			OBDal.getInstance().rollbackAndClose();
			String cause = ExceptionUtils.getRootCauseMessage(ExceptionUtils.getRootCause(e.getCause()));
			String message = cause != null && !cause.isEmpty() ? cause : e.getMessage();
			log4j.error("Exception found in UpdateFOB process: ", e);
			// Throwable exception = DbUtility.getUnderlyingSQLException(e);
			// String message =
			// OBMessageUtils.translateError(exception.getMessage()).getMessage();
			msg.setType("Error");
			msg.setTitle(OBMessageUtils.messageBD("Error"));
			// msg.setMessage(message);
			msg.setMessage(OBMessageUtils.translateError(message).getMessage());
		} finally {
			OBContext.setAdminMode(false);
			bundle.setResult(msg);
		}
	}

	private void process(String recordId) throws Exception {
		try {
			order = OBDal.getInstance().get(Order.class, recordId);
			if (order.getSsipImportstatus().equals("LL")) {
				throw new OBException("Importación liquidada");
			}

			Table table = OBDal.getInstance().get(Table.class, tableId);
			Attachment attach = getAttachment(recordId, table);
			if (attach == null) {
				throw new OBException("Archivo CSV no encontrado");
			}
			String filename = attachPath + "/" + attach.getPath() + '/' + attach.getName();
			System.out.println(filename);

			List<Map> data = loadCSV(filename, 4);
			validate(data);
			insert(data);
		} finally {
		}
	}

	private Attachment getAttachment(String recordId, Table table) throws Exception {
		Attachment attach = null;

		try {
			OBCriteria<Attachment> attachmentList = OBDal.getInstance().createCriteria(Attachment.class);
			attachmentList.add(Restrictions.eq(Attachment.PROPERTY_TABLE, table));
			attachmentList.add(Restrictions.eq(Attachment.PROPERTY_RECORD, recordId));
			attachmentList.add(Restrictions.eq(Attachment.PROPERTY_DATATYPE, dataType));
			attachmentList.setFilterOnReadableOrganization(false);
			attachmentList.uniqueResult();

			if (attachmentList.list().size() > 0) {
				attach = attachmentList.list().get(0);
			}
		} finally {
		}

		return attach;
	}

	private void validate(List<Map> data) throws Exception {
		try {
			int i = 2;
			for (Map<String, String> row : data) {
				String message = "";

				if (row.get("Linea") == null || row.get("Linea").isEmpty())
					message += "La línea es obligatoria<br />";

				if (row.get("Identificador") == null || row.get("Identificador").isEmpty())
					message += "El identificador es obligatorio<br />";

				if (row.get("Cantidad Pedido") == null || row.get("Cantidad Pedido").isEmpty())
					message += "La cantidad pedida es obligatoria<br />";

				if (row.get("Precio Unitario") == null || row.get("Precio Unitario").isEmpty())
					message += "El precio unitario es obligatorio<br />";

				String duplicate = findDuplicates(data, "Linea");
				if (duplicate != null) {
					message += "Valor " + duplicate + " duplicado en la columna \"Linea\"<br />";
				}

				duplicate = findDuplicates(data, "Identificador");
				if (duplicate != null) {
					message += "Valor " + duplicate + " duplicado en la columna \"Identificador\"<br />";
				}

				Long line = new Long(0);
				try {
					line = new Long(row.get("Linea"));
				} catch (Exception e) {
					message += "El formato de la columna \"Linea\" es invalido<br />";
				}

				OBCriteria<Product> productQuery = OBDal.getInstance().createCriteria(Product.class);
				productQuery.add(Restrictions.eq(Product.PROPERTY_SEARCHKEY, row.get("Identificador")));
				List<Product> products = productQuery.list();
				if (products.size() == 0)
					throw new OBException("Producto " + row.get("Identificador") + " no encontrado");
				Product product = products.get(0);

				OBCriteria<OrderLine> orderLineQuery = OBDal.getInstance().createCriteria(OrderLine.class);
				orderLineQuery.add(Restrictions.eq(OrderLine.PROPERTY_SALESORDER, order));
				orderLineQuery.add(Restrictions.eq(OrderLine.PROPERTY_LINENO, line));
				orderLineQuery.add(Restrictions.eq(OrderLine.PROPERTY_PRODUCT, product));
				List<OrderLine> orderLines = orderLineQuery.list();
				if (orderLines.size() == 0)
					throw new OBException("Linea  " + row.get("Linea") + " con Identificador "
							+ row.get("Identificador") + " no encontrada");

				BigDecimal qtyOrdered = new BigDecimal(0);
				try {
					qtyOrdered = new BigDecimal(row.get("Cantidad Pedido"));
				} catch (Exception e) {
					message += "El formato de la columna \"Cantidad Pedido\" es invalido<br />";
				}

				BigDecimal priceActual = new BigDecimal(0);
				try {
					priceActual = new BigDecimal(row.get("Precio Unitario"));
				} catch (Exception e) {
					message += "El formato de la columna \"Precio Unitario\" es invalido<br />";
				}

				if (!message.isEmpty()) {
					throw new OBException("Fila: " + i + "<br />" + message);
				}
				i++;
			}
		} finally {
		}
	}

	private void insert(List<Map> data) throws Exception {
		try {
			User user = OBContext.getOBContext().getUser();

			for (Map<String, String> row : data) {

				OBCriteria<Product> productQuery = OBDal.getInstance().createCriteria(Product.class);
				productQuery.add(Restrictions.eq(Product.PROPERTY_SEARCHKEY, row.get("Identificador")));
				Product product = productQuery.list().get(0);

				OBCriteria<OrderLine> orderLineQuery = OBDal.getInstance().createCriteria(OrderLine.class);
				orderLineQuery.add(Restrictions.eq(OrderLine.PROPERTY_SALESORDER, order));
				orderLineQuery.add(Restrictions.eq(OrderLine.PROPERTY_LINENO, new Long(row.get("Linea"))));
				orderLineQuery.add(Restrictions.eq(OrderLine.PROPERTY_PRODUCT, product));
				OrderLine orderLine = orderLineQuery.list().get(0);

				BigDecimal qtyOrdered = new BigDecimal(row.get("Cantidad Pedido"));
				orderLine.setOrderedQuantity(qtyOrdered);
				BigDecimal priceActual = new BigDecimal(row.get("Precio Unitario"));
				orderLine.setUnitPrice(priceActual);

				OBDal.getInstance().save(orderLine);
				OBDal.getInstance().flush();
			}
		} finally {
		}
	}

	private List<Map> loadCSV(String filename, int numberOfColumns) throws Exception {
		List<Map> data = new ArrayList<Map>();
		CSVReader csvReader = null;
		try {

			csvReader = new CSVReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"), ',', '\"', '\\', 0,
					false, true);

			List<String[]> csv = csvReader.readAll();

			List<String> title = new ArrayList<String>();
			int i = 0;
			for (String[] row : csv) {
				int j = 0;
				Map<String, String> record = new HashMap<String, String>();

				for (String cell : row) {
					if (i == 0)
						title.add(cell != null ? cell.trim() : cell);
					else
						record.put(title.get(j), cell != null ? cell.trim() : cell);
					System.out.print(cell + "\t");
					j++;
				}
				System.out.println();

				if (j != numberOfColumns)
					throw new OBException("El numero de columnas no coincide con el formato");

				if (i > 0)
					data.add(record);

				i++;
			}
			if (i <= 1)
				throw new OBException("No se encontraron datos en el archivo");
		} finally {
			if (csvReader != null) {
				csvReader.close();
			}
		}
		return data;
	}

	private String findDuplicates(List<Map> data, String columnName) {

		Set<String> lump = new HashSet<String>();
		for (Map<String, String> row : data) {
			if (lump.contains(row.get(columnName)))
				return row.get(columnName);
			lump.add(row.get(columnName));
		}
		return null;
	}
}
