package com.spring.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MessageUtil {
	
	public Map<String, String> getMessage(String mes){
		Map<String, String> result = new HashMap<>();
		if(mes.equals("update_success")) {
			result.put("message", "update success");
			result.put("alert", "success");
		}else if(mes.equals("insert_success")) {
			result.put("message", "insert success");
			result.put("alert", "success");
		}else if(mes.equals("remove_success")) {
			result.put("message", "remove success");
			result.put("alert", "success");
		}else if(mes.equals("error_system")) {
			result.put("message", "error system");
			result.put("alert", "danger");
		}
		return result;
		
	}

	
}
