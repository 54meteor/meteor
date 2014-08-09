package net.yasite.net.httpclient;

import java.security.KeyStore;

import net.yasite.api.BaseAPI;
import net.yasite.net.HttpConstant;
import net.yasite.net.SSLSocketFactoryEx;
import net.yasite.util.ActivityUtil;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public abstract class AHttpClient {
	protected HttpUriRequest request;
	protected DefaultHttpClient httpClient;
	protected HttpResponse response;
	protected String content = "";
	
	
	
	public DefaultHttpClient getHttpClient() {
		return httpClient;
	}

	public void setHttpClient(DefaultHttpClient httpClient) {
		this.httpClient = httpClient;
	}

	public AHttpClient(BaseAPI params){
		if (ActivityUtil.isWifiConnected(params.getContext())) {
			httpClient = getDefaultHttpClient(HttpConstant.DEFAULT_TIMEOUT);
		} else {
			httpClient = getDefaultHttpClient(HttpConstant.MAX_TIMEOUT);
		}
	}
	
	public HttpUriRequest getRequest() {
		return request;
	}

	public void setRequest(HttpUriRequest request) {
		this.request = request;
	}

	public abstract void doRequest(BaseAPI param) throws Exception ;
	
	
	protected void excute(HttpResponse response,
			String content,BaseAPI param) throws Exception{
		try {
			int statusCode = response.getStatusLine().getStatusCode();
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
	
	public DefaultHttpClient getDefaultHttpClient(int timeout) {
		try {
			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			trustStore.load(null, null);

			SSLSocketFactory sf = new SSLSocketFactoryEx(trustStore);
			sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

			HttpParams params = new BasicHttpParams();
			HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
			HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
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
}
