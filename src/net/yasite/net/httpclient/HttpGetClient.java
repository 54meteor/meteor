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
		super(param);
		request = new HttpGet(param.getMethod());
		request.addHeader("Pragma", "no-cache");
	    request.addHeader("Cache-Control", "no-cache");
	}

	@Override
	public void doRequest(BaseAPI param)  throws Exception {
		response = httpClient.execute(request);
		excute(response, content, param);
	}

}
