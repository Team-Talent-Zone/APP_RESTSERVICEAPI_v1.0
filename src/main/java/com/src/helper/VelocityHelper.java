package com.src.helper;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VelocityHelper {

	final Logger logger = LoggerFactory.getLogger(VelocityHelper.class);
	 
	public VelocityContext generateVelocityObject(JSONArray jsonArray) throws JSONException {
		VelocityContext context = new VelocityContext();
		try {
			logger.info("Inside the Send Email Class Of SentEmailUtility Jar : GenerateVelocityObject method");
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject objectInArray = jsonArray.getJSONObject(i);
				String[] elementNames = JSONObject.getNames(objectInArray);
				for (String elementName : elementNames) {
					String value = objectInArray.getString(elementName);
					context.put(elementName, value);
				}
			}
		} catch (Exception e) {
		}
		return context;
	}

	public String generateEmailInHtmlFormat(String tempServerURLEmailTemplateName, VelocityContext context) {
		StringWriter writer = null;
		try {
			logger.debug(
					"Inside GenerateEmailInHtmlFormat method of SendEmail Utility Jar of : AbstractEmailConfig Class ");
			VelocityEngine ve = new VelocityEngine();
			ve.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.SimpleLog4JLogSystem");
			ve.setProperty("runtime.log.logsystem.log4j.category", "velocity");
			ve.setProperty("runtime.log.logsystem.log4j.logger", "velocity");

			ve.setProperty("resource.loader", "url");
			ve.setProperty("url.resource.loader.class",
					"org.apache.velocity.runtime.resource.loader.URLResourceLoader");
			ve.setProperty("url.resource.loader.root", (Object) tempServerURLEmailTemplateName.substring(0,
					tempServerURLEmailTemplateName.lastIndexOf('/') + 1));
			logger.debug(
					"Inside GenerateEmailInHtmlFormat method of SendEmail Utility Jar of : AbstractEmailConfig Class : Template URL :  "
							+ tempServerURLEmailTemplateName);
			ve.init();
			Template t = ve.getTemplate(
					tempServerURLEmailTemplateName.substring(tempServerURLEmailTemplateName.lastIndexOf('/') + 1));
			writer = new StringWriter();
			t.merge(context, writer);
		} catch (Exception e) {
			logger.error(
					"Inside GenerateEmailInHtmlFormat method of SendEmail Utility Jar of : AbstractEmailConfig Class : Error Occured :"
							+ e.toString());
			return null;
		}
		return writer.toString();
	}

}
