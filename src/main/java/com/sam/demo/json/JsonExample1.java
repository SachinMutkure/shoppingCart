package com.sam.demo.json;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;
import com.google.gson.JsonObject;
import com.sam.demo.dto.Employee;

public class JsonExample1 {
	public static final Logger LOG = LoggerFactory.getLogger(JsonExample1.class);
	public static void main(String[] args) {
		JSONObject obj = new JSONObject();
		obj.put("Kay1", "Sachin");
		obj.put("Kay2", "Kiran");
		obj.put("Kay3", "Satish");
		obj.put("Kay4", new Integer(11));
		obj.put("Kay5", new Double(4454.55));
		
		System.out.println(obj);
		
		
		Map obj1=new HashMap();    
		  obj1.put("name","sonoo");    
		  obj1.put("age",new Integer(27));    
		  obj1.put("salary",new Double(600000));
		  String jsonText = JSONValue.toJSONString(obj1);
		  System.out.println(jsonText);	  
		
		
	}
}
