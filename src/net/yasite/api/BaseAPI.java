package net.yasite.api;

import java.util.List;

import net.yasite.api.params.BaseHttpParam;
import net.yasite.net.HttpConstant;
import net.yasite.net.httpclient.AHttpClient;
import net.yasite.net.httpclient.HttpGetClient;
import net.yasite.net.httpclient.HttpPostClent;
import net.yasite.net.httpclient.HttpUploadClient;
import net.yasite.test.BaseApplication;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public abstract class BaseAPI implements HttpAPI {

	public Context context;
	private int status;
	private String paramStr;
	private List <NameValuePair> valuePair;//post请求数据
	private List <NameValuePair> fileList;//文件上传数据
	private int statuesCode;
	private SharedPreferences prefs;
	JSONObject json = new JSONObject();
	HttpResponse res;
	AHttpClient httpClient;
	public HttpResponse getRes() {
		return res;
	}

	public void setRes(HttpResponse res) {
		this.res = res;
	}

	public int getStatuesCode() {
		return statuesCode;
	}

	public void setStatuesCode(int statuesCode) {
		this.statuesCode = statuesCode;
	}
	

	public List<NameValuePair> getFileList() {
		return fileList;
	}

	public void setFileList(List<NameValuePair> fileList) {
		this.fileList = fileList;
	}

	private BaseAPI() {

	}

	protected BaseAPI(Context context) {
		this.context = context;
		
	}
	
	/**
	 * api名称
	 */
	private String method;

	/**
	 * 请求参数
	 */
	private BaseHttpParam requestParam;

	/**
	 * 返回数据
	 */
	private Object response;

	/**
	 * 处理结果
	 */
	private Object handleResult;

	
	public BaseAPI(Context context,BaseHttpParam pm) {
		this.context = context;
		this.requestParam = pm;
	} 
	public BaseAPI(Context context,List <NameValuePair> pm) {
		this.context = context;
		this.valuePair = pm;
	} 
	public BaseAPI(Context context,List <NameValuePair> pm,
			List <NameValuePair> fileList) {
		this.context = context;
		this.valuePair = pm;
		this.fileList = fileList;
	} 
	
	public BaseAPI(Context context,List <NameValuePair> pm,BaseHttpParam params) {
		this.context = context;
		this.valuePair = pm;
		this.requestParam = params;
	}

	public boolean doUpload() throws Exception {
		httpClient = new HttpUploadClient(this);
		return doRequest();
	}

	public boolean doPost() throws Exception {
		httpClient = new HttpPostClent(this);
		return doRequest();
	}

	public boolean doGet() throws Exception {
		httpClient = new HttpGetClient(this);
        return doRequest();
    }
	private boolean doRequest() throws Exception{
		if (method == null) {
			Log.e(HttpConstant.DUG_TYPE_ERROR, "未设置请求方法");
			return false;
		}
		// 请求参数验证
		if(BaseApplication.DEBUG){
			System.out.println("请求参数:" +  getMethod());
		}
		httpClient.doRequest(this);
		
		if(response != null){
			if(response.toString().startsWith("[")){
				json.put("list", new JSONArray(response.toString()));
			}else if(response.toString().startsWith("<html>")){
				json.put("content", response.toString());
			}else if(response.toString().startsWith("<?xml")){
				json.put("content", response.toString());
			}else{
				json = new JSONObject(response.toString());
			}
			if(BaseApplication.DEBUG){
				System.out.println("返回结果:" + json.toString());
			}
			setHandleResult(handlerResult(json));
			return true;
		}
		return false;
	}

	@Override
	public int handlerError(JSONObject json) throws JSONException,Exception {
		throw new Exception("操作失败!");
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}
	

	/**
	 * api地址
	 * 
	 * @param method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * api地址
	 * 
	 * @param method
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * 返回状态
	 * @return
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * 设置请求参数
	 * 
	 * @param requestParam
	 */
	public void setRequestParam(BaseHttpParam requestParam) {
		this.requestParam = requestParam;
	}

	/**
	 * 服务端返回josn数据
	 * 
	 * @param response
	 */
	public void setResponse(Object response) {
		this.response = response;
	}

	/**
	 * 处理服务端返回的结果. 返回数据类型,见BaseAPI子类中HandlerResult方法, 如果非正常返回则反回错误状态码
	 */
	public Object getHandleResult() {
		return handleResult;
	}

	
	public void setHandleResult(Object object) {
		this.handleResult = object;
	}

	public List<NameValuePair> getValuePair() {
		return valuePair;
	}

	public void setValuePair(List<NameValuePair> valuePair) {
		this.valuePair = valuePair;
	}


	public BaseHttpParam getRequestParam() {
		return requestParam;
	}
	
	public String getRequestParamToString(){
		return this.paramStr;
	}
	public void saveToken(String nameValuePairs){
		prefs = PreferenceManager.getDefaultSharedPreferences(context);
		prefs.edit().putString(BaseApplication.TOKEN, nameValuePairs).commit();
		
	}
	public String getToken(){
		prefs = PreferenceManager.getDefaultSharedPreferences(context);
		return prefs.getString(BaseApplication.TOKEN, "");
	}

	public SharedPreferences getPrefs() {
		return prefs;
	}

	public void setPrefs(SharedPreferences prefs) {
		this.prefs = prefs;
	}
}
