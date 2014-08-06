package net.yasite.net.httpclient;

import java.io.File;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import net.yasite.api.BaseAPI;
import net.yasite.api.params.HttpParam;
import net.yasite.net.HttpConstant;
import net.yasite.util.ActivityUtil;

public class HttpUploadClient extends HttpPostClent {

	public HttpUploadClient(BaseAPI param) {
		super(param);
	}

	@Override
	public void doRequest(BaseAPI param) throws Exception {
		DefaultHttpClient httpClient = null;
		if (ActivityUtil.isWifiConnected(param.getContext())) {
			httpClient = getDefaultHttpClient(HttpConstant.DEFAULT_TIMEOUT);
		} else {
			httpClient = getDefaultHttpClient(HttpConstant.MAX_TIMEOUT);
		}
		HttpResponse response = null;
		String content = "";
		try {
			HttpContext httpContext = new BasicHttpContext();
			MultipartEntity multipartContent = new MultipartEntity();
			HttpParam pm = (HttpParam) param.getRequestParam();
			multipartContent.addPart("avatar", new FileBody(new File(pm.getFilePath())));
			
			((HttpPost)request).setEntity(multipartContent);
			response = httpClient.execute(request, httpContext);
			int statusCode = response.getStatusLine().getStatusCode();
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
			request.abort();
		}

	}

}
