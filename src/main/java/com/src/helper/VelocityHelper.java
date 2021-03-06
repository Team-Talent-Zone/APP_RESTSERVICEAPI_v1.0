package com.src.helper;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The <code> VelocityHelper </code> class defines email service auto
 * scheduling.
 * 
 * @author Ishaq.
 * @version 1.0
 *
 */
public class VelocityHelper {
	final Logger logger = LoggerFactory.getLogger(VelocityHelper.class);

	/**
	 * This method will generate email via velocity object.
	 * 
	 * @param jsonArray
	 * @throws Exception
	 */
	public VelocityContext generateVelocityObject(JSONArray jsonArray) throws Exception {
		VelocityContext context = new VelocityContext();
		logger.info("Inside the VelocityHelper Class  : generateVelocityObject method");
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject objectInArray = jsonArray.getJSONObject(i);
			String[] elementNames = JSONObject.getNames(objectInArray);
			for (String elementName : elementNames) {
				String value = objectInArray.getString(elementName);
				context.put(elementName, value);
			}
		}
		return context;
	}

	/**
	 * This method is to generate Email in HTML Format.
	 * 
	 * @param tempServerURLEmailTemplateName
	 * @param context
	 */
	public String generateEmailInHtmlFormat(String tempServerURLEmailTemplateName, VelocityContext context) {
		StringWriter writer = null;
		logger.debug("Inside the VelocityHelper Class : generateEmailInHtmlFormat method : templateURL :"
				+ tempServerURLEmailTemplateName);
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.SimpleLog4JLogSystem");
		ve.setProperty("runtime.log.logsystem.log4j.category", "velocity");
		ve.setProperty("runtime.log.logsystem.log4j.logger", "velocity");

		ve.setProperty("resource.loader", "url");
		ve.setProperty("url.resource.loader.class", "org.apache.velocity.runtime.resource.loader.URLResourceLoader");
		ve.setProperty("url.resource.loader.root", (Object) tempServerURLEmailTemplateName.substring(0,
				tempServerURLEmailTemplateName.lastIndexOf('/') + 1));
		ve.init();
		Template t = ve.getTemplate(
				tempServerURLEmailTemplateName.substring(tempServerURLEmailTemplateName.lastIndexOf('/') + 1));
		writer = new StringWriter();
		t.merge(context, writer);
		return writer.toString();
	}

}
