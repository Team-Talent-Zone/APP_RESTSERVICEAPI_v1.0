package com.src.testsamplecode;

import org.apache.velocity.VelocityContext;
import org.json.JSONArray;
import org.json.JSONObject;

public class TestCode {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String compactJson = "{\"playerID\":1234,\"name\":\"Test\",\"itemList\":[{\"itemID\":1,\"name\":\"Axe\",\"atk\":12,\"def\":0},{\"itemID\":2,\"name\":\"Sword\",\"atk\":5,\"def\":5},{\"itemID\":3,\"name\":\"Shield\",\"atk\":0,\"def\":10}]}";
		JSONArray jsonarray = new JSONArray();
		JSONObject jsonObj = new JSONObject(compactJson);
		jsonarray.put(jsonObj);
		generateVelocityObject(jsonarray);
	}
	public static VelocityContext generateVelocityObject(JSONArray jsonArray) throws Exception {
		VelocityContext context = new VelocityContext();
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

}
