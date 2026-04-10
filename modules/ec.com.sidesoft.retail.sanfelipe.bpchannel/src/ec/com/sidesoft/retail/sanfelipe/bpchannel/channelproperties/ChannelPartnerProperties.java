package ec.com.sidesoft.retail.sanfelipe.bpchannel.channelproperties;

import java.util.ArrayList;
import java.util.List;

import org.openbravo.client.kernel.ComponentProvider.Qualifier;
import org.openbravo.mobile.core.model.HQLProperty;
import org.openbravo.mobile.core.model.ModelExtension;

/**
 * @author Carlos Chiza
 * 
 */
@Qualifier(BpChannel.channellistPropertyExtension )
public class ChannelPartnerProperties extends ModelExtension {

	@Override
	public List<HQLProperty> getHQLProperties(Object params) {
		ArrayList<HQLProperty> list = new ArrayList<HQLProperty>() {
			private static final long serialVersionUID = 1L;
			{
				add(new HQLProperty("ud1.id", "id"));
				add(new HQLProperty("ud1.id", "searchKey"));
				add(new HQLProperty("ud1.name", "name"));
				add(new HQLProperty("ud1.name", "_identifier"));
			}
		};
		return list;
	}

}
