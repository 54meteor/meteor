package net.yasite.net;

import org.json.JSONObject;

/**
 * 
 * Desc:TODO http请求参数,返回结果数据转换器 Date:2013-3-7 Author:admin
 */
public class HttpDataConverter {

	private HttpDataConverter() {

	}

	// json数据转换成对象
	public static Object jsonToBean(JSONObject resource, Class c) {
		return null;
	}

	// json数据转换成xml
	public static XmlDoc jsonToXml(JSONObject resource) {
		return null;
	}

	// xml数据转换成json
	public static JSONObject xmlToJson(XmlDoc resource) {
		return null;
	}
}
