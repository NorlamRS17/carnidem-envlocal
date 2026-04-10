package ec.com.sidesoft.web.services.order.route.service.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;
import org.openbravo.base.exception.OBException;
import org.openbravo.erpCommon.utility.OBMessageUtils;
import org.openbravo.service.db.DbUtility;

public abstract class Ssfor_Utils {

	static public String post(String endpoint, JSONObject body) throws Exception {
		URL url = new URL(endpoint);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Accept", "application/json");
		conn.setDoOutput(true);

		String jsonInputString = body.toString();
		OutputStream os = conn.getOutputStream();
		byte[] input = jsonInputString.getBytes("utf-8");
		os.write(input, 0, input.length);

		int status = conn.getResponseCode();
		if (status != 200) {
			throw new OBException("Post request error. Status " + Integer.toString(status));
		}

		BufferedReader br = new BufferedReader(
				new InputStreamReader(conn.getInputStream(), "utf-8"));
		StringBuilder response = new StringBuilder();
		String responseLine = null;
		while ((responseLine = br.readLine()) != null) {
			response.append(responseLine.trim());
		}

		return response.toString();
	}

	static public String getErrorMessage(Logger logger, Exception e) {
		Throwable throwable = DbUtility.getUnderlyingSQLException(e);
		String message = OBMessageUtils.translateError(throwable.getMessage()).getMessage();
		logger.error(message);
		return message;
	}

	static public JSONObject readAllIntoJSONObject(InputStream content) throws Exception {
		BufferedReader rd = new BufferedReader(
				new InputStreamReader(content, StandardCharsets.UTF_8));
		String jsonText = IOUtils.toString(rd);
		return new JSONObject(jsonText);
	}

	static public String getString(JSONObject json, String key, boolean required) throws Exception {
		String value = json.has(key) ? json.getString(key) : null;
		if (value == null || value.trim().isEmpty()) {
			if (required) {
				throw new OBException(key + " is required");
			}
			return null;
		}
		return value.trim();
	}

	static public Long getLong(JSONObject json, String key, boolean required) throws Exception {
		String value = json.has(key) ? json.getString(key) : null;
		if (value == null || value.trim().isEmpty()) {
			if (required) {
				throw new OBException(key + " is required");
			}
			return null;
		}
		value = value.trim();
		try {
			return new Long(value);
		} catch (Exception e) {
			throw new OBException("Wrong integer format for" + key);
		}
	}

	static public BigDecimal getBigDecimal(JSONObject json, String key, boolean required)
			throws Exception {
		String value = json.has(key) ? json.getString(key) : null;
		if (value == null || value.trim().isEmpty()) {
			if (required) {
				throw new OBException(key + " is required");
			}
			return null;
		}
		value = value.trim();
		try {
			return new BigDecimal(value);
		} catch (Exception e) {
			throw new OBException("Wrong double format for" + key);
		}
	}

	static public Boolean getBoolean(JSONObject json, String key, boolean required)
			throws Exception {
		String value = json.has(key) ? json.getString(key) : null;
		if (value == null || value.trim().isEmpty()) {
			if (required) {
				throw new OBException(key + " is required");
			}
			return null;
		}
		value = value.trim();
		if (!(value.equals("true") || value.equals("false"))) {
			throw new OBException("Wrong data type for" + key);
		}
		return value.equals("true");
	}

	static public Date getDate(JSONObject json, String key, boolean required) throws Exception {
		String value = json.has(key) ? json.getString(key) : null;
		if (value == null || value.trim().isEmpty()) {
			if (required) {
				throw new OBException(key + " is required");
			}
			return null;
		}
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return df.parse(value.trim());
		} catch (Exception e) {
			throw new OBException("Wrong date format for" + key);
		}
	}

	static public String getDateString(Date date) throws IOException {
		if (date == null) {
			return null;
		} else {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			return df.format(date);
		}
	}

	static public String getTimestampString(Date date) throws IOException {
		if (date == null) {
			return null;
		} else {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			return df.format(date);
		}

	}

	  static public String stripExtraInformation(String message) {
	    String cleanedMsg;
	    // if the message is a directly from postgres generated one, it has an 'ERROR :' prefix
	    // if it is passed via an AD_PINSTACE result, then the 'ERROR: ' has already been stripped
	    if ((message.length() > 7) && (message.startsWith("ERROR: "))) {
	      cleanedMsg = message.substring(7);
	    } else {
	      cleanedMsg = message;
	    }
	    // remove technical information added by the PostgreSQL JDBC driver
	    int pos = cleanedMsg.indexOf("\n  Where: ");
	    if (pos != -1) {
	      cleanedMsg = cleanedMsg.substring(0, pos);
	    }

	    return cleanedMsg;
	  }

	  //private public String getErrorMessage1(Exception e) {
	  //  Throwable throwable = DbUtility.getUnderlyingSQLException(e);
	  //  String message = OBMessageUtils.translateError(throwable.getMessage()).getMessage();
	  //  return message;
	  //}

}
