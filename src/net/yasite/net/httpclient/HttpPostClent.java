package net.yasite.net.httpclient;

import net.yasite.api.BaseAPI;
import net.yasite.net.HttpConstant;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class HttpPostClent extends AHttpClient {

	
	public HttpPostClent(BaseAPI param){
		super(param);
		request = new HttpPost(param.getMethod());
		request.addHeader("Pragma", "no-cache");
	    request.addHeader("Cache-Control", "no-cache");
	    request.addHeader("charset", HTTP.UTF_8);
	    
	}
	@Override
	public void doRequest(BaseAPI param)  throws Exception {
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(param.getValuePair(),HTTP.UTF_8);
		((HttpPost) request).setEntity(entity);
		response = httpClient.execute(request);
		excute(response, content, param);
	}

}
