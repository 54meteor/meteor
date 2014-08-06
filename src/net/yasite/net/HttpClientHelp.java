package net.yasite.net;

import java.io.File;
import java.security.KeyStore;

import net.yasite.api.BaseAPI;
import net.yasite.api.params.HttpParam;
import net.yasite.api.params.Urls;
import net.yasite.constant.AppConstant;
import net.yasite.util.ActivityUtil;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;



public class HttpClientHelp {

	private HttpClientHelp httpClientHelp;
	HttpUriRequest request;
	
	public HttpClientHelp(BaseAPI param){
		request = new HttpGet(param.getMethod());
		request.addHeader("Pragma", "no-cache");
	    request.addHeader("Cache-Control", "no-cache");
	}
	
	
	public HttpUriRequest getRequest() {
		return request;
	}

	public void setRequest(HttpUriRequest request) {
		this.request = request;
	}




	public void doGetRequest(BaseAPI param) throws Exception{
	    doRequest(param);
	}
	
//	public void doPostRequest(BaseAPI param) throws Exception{
//	    request = new HttpPost(param.getMethod());
//	    doRequest(param);
//	}
	
	public void doPostRequest(BaseAPI param) throws Exception {
		DefaultHttpClient httpClient = getDefaultHttpClient(HttpConstant.DEFAULT_TIMEOUT);
		HttpResponse response = null;
		String content = "";
		HttpPost request = new HttpPost(param.getMethod());
		try {
	        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(param.getValuePair(),HTTP.UTF_8);
	        request.setEntity(entity);
	        request.addHeader("Pragma", "no-cache");
	        request.addHeader("Cache-Control", "no-cache");
	        request.addHeader("charset", HTTP.UTF_8);
			response = httpClient.execute(request);
			int statusCode = getStatusCode(response.getStatusLine().getStatusCode());
			if (statusCode == HttpStatus.SC_OK) {
				content = EntityUtils.toString(response.getEntity(), "utf-8");
				if (content == null || "".equals(content)) {
					throw new Exception("服务器繁忙!");
				} else {
					param.setResponse(content);
					param.setStatuesCode(statusCode);
					param.setRes(response);
				}
			} else if (statusCode == HttpStatus.SC_INTERNAL_SERVER_ERROR) {
				throw new Exception("服务器异常!");
			} 
		} catch (ConnectTimeoutException e) {
			throw new Exception("请求超时!");
		} catch (java.lang.OutOfMemoryError e) {
			throw new Exception("系统出错!");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("服务器繁忙!");
		} finally {
			request.abort();
		}

	}

	/**
	 * 执行具体http请求
	 * 
	 * @param param
	 *            请求参数
	 * @throws Exception
	 * @throws LalaHttpException
	 */
	public void doRequest(BaseAPI param) throws Exception {
		DefaultHttpClient httpClient = getDefaultHttpClient(HttpConstant.DEFAULT_TIMEOUT);
		HttpResponse response = null;
		String content = "";
		try {
			response = httpClient.execute(request);
			int statusCode = getStatusCode(response.getStatusLine().getStatusCode());
			if (statusCode == HttpStatus.SC_OK) {
				content = EntityUtils.toString(response.getEntity(), "utf-8");
				if (content == null || "".equals(content)) {
					throw new Exception("服务器繁忙!");
				} else {
					param.setResponse(content);
					param.setStatuesCode(statusCode);
				}
			} else if (statusCode == HttpStatus.SC_INTERNAL_SERVER_ERROR) {
				throw new Exception("服务器异常!");
			}
		} catch (ConnectTimeoutException e) {
			throw new Exception("请求超时!");
		} catch (java.lang.OutOfMemoryError e) {
			throw new Exception("系统出错!");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("服务器繁忙!");
		} finally {
			request.abort();
		}

	}

	/**
	 * 执行具体http put请求
	 * 
	 * @param param
	 *            请求参数
	 * @throws Exception
	 * @throws LalaHttpException
	 */
	public void doUploadFile(BaseAPI param) throws Exception {

		// HttpClient httpClient = new DefaultHttpClient();
		// 判断网络类型
		DefaultHttpClient httpClient = null;
		if (ActivityUtil.isWifiConnected(param.getContext())) {
			httpClient = getDefaultHttpClient(HttpConstant.DEFAULT_TIMEOUT);
		} else {
			httpClient = getDefaultHttpClient(HttpConstant.MAX_TIMEOUT);
		}
		HttpPost httpost = null;
		HttpResponse response = null;
		String content = "";
		try {
			HttpContext httpContext = new BasicHttpContext();
			httpost = new HttpPost(param.getMethod());
			MultipartEntity multipartContent = new MultipartEntity();
			HttpParam pm = (HttpParam) param.getRequestParam();
			multipartContent.addPart("avatar", new FileBody(new File(pm.getFilePath())));
			
			httpost.setEntity(multipartContent);
			httpost.addHeader("Pragma", "no-cache");
			httpost.addHeader("Cache-Control", "no-cache");
			httpost.addHeader("Authorization",param.getToken());
			httpost.addHeader("UUID",param.prefs.getString("UUID", null));
			response = httpClient.execute(httpost, httpContext);
			int statusCode = getStatusCode(response.getStatusLine().getStatusCode());
			if (statusCode == HttpStatus.SC_OK || statusCode == HttpStatus.SC_BAD_REQUEST) {
				content = EntityUtils.toString(response.getEntity(), "utf-8");
				if (content == null || "".equals(content)) {
					throw new Exception("服务器繁忙!");
				} else {
					param.setResponse(content);
					param.setStatuesCode(statusCode);
				}
			} else if (statusCode == HttpStatus.SC_INTERNAL_SERVER_ERROR) {
				throw new Exception("服务器异常!");
			}
		} catch (ConnectTimeoutException e) {
			throw new Exception("请求超时");
		} catch (java.lang.OutOfMemoryError e) {
			throw new Exception("数据量过大");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("服务器繁忙");
		} finally {
			httpost.abort();
		}

	}
	
	

	public static DefaultHttpClient getDefaultHttpClient(int timeout) {
		try {
			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			trustStore.load(null, null);

			SSLSocketFactory sf = new SSLSocketFactoryEx(trustStore);
			sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

			HttpParams params = new BasicHttpParams();
			HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
			HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
			HttpProtocolParams.setUserAgent(params, "News/" + AppConstant.VERSIONCODE 
					+ " Android/" +  AppConstant.VERSIONCODE);
			HttpConnectionParams.setConnectionTimeout(params, HttpConstant.CONNECTION_TIMEOUT);
			HttpConnectionParams.setSoTimeout(params, timeout);

			SchemeRegistry registry = new SchemeRegistry();
			registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
			registry.register(new Scheme("https", sf, 443));

			ClientConnectionManager ccm = new ThreadSafeClientConnManager(params, registry);

			return new DefaultHttpClient(ccm, params);
		} catch (Exception e) {
			return new DefaultHttpClient();
		}
	}
	private int getStatusCode(int code){
//		System.out.println(code);
		if(code >= 200 && code <= 299){
			return 200;
		}else if(code >= 400 && code <= 499){
			return 400;
		}else{
			return code;
		}
	}
	private void sysHeader(HttpResponse response){
		System.out.println(response.getAllHeaders().toString());
		for(Header head : response.getAllHeaders()){
			System.out.println(head.getName() +  "::::" + head.getValue());
		}
	}
}
