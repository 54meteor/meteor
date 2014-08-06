package net.yasite.api;

import org.json.JSONException;
import org.json.JSONObject;


public interface HttpAPI {

	/**
	 * 处理请求结果
	 * 
	 * @return
	 */
	public Object handlerResult(JSONObject json) throws JSONException;
	
	/**
	 * 处理请求结果中的异常
	 * 
	 * @return
	 */
	public int handlerError(JSONObject json)throws JSONException,Exception;

}
