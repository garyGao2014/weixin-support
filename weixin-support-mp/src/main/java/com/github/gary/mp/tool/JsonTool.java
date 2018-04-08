package com.github.gary.mp.tool;

import com.alibaba.fastjson.JSON;

public class JsonTool {

	private JsonTool(){}

	public static <T> T parseObject(String json,Class<T> clazz){
		return JSON.parseObject(json, clazz);
	}

	public static String toJSONString(Object object){
		return JSON.toJSONString(object);
	}
}
