package net.yasite.net.httpclient;

import net.yasite.api.BaseAPI;
import net.yasite.net.HttpConstant;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpGetClient extends AHttpClient {
	
	public HttpGetClient(BaseAPI param){
		request = new HttpGet(param.getMethod());
		request.addHeader("Pragma", "no-cache");
	    request.addHeader("Cache-Control", "no-cache");
	}

	@Override
	public void doRequest(BaseAPI param)  throws Exception {
		DefaultHttpClient httpClient = getDefaultHttpClient(HttpConstant.DEFAULT_TIMEOUT);
		HttpResponse response = null;
		String content = "";
		try {
			response = httpClient.execute(request);
			int statusCode = response.getStatusLine().getStatusCode();
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

}
