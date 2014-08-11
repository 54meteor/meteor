package net.yasite.net.httpclient;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
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
		HttpContext httpContext = new BasicHttpContext();
		((HttpPost)request).setEntity(setPartEntity(param));
		response = httpClient.execute(request, httpContext);
		excute(response, content, param);
	}
	
	
	private MultipartEntity setPartEntity(BaseAPI param) throws UnsupportedEncodingException{
		MultipartEntity multipartContent = new MultipartEntity();
		//处理非文件类提交
		for(int i = 0; i < param.getValuePair().size(); i++){
			if(param.getValuePair().get(i) != null){
				multipartContent.addPart(
						param.getValuePair().get(i).getName(),
						new StringBody(param.getValuePair().get(i).getValue(),  
								Charset.forName(HTTP.UTF_8)));
			}
		}
		//处理文件类提交
		for(int i = 0; i < param.getFileList().size(); i++){
			if(param.getFileList().get(i) != null){
				multipartContent.addPart(
						param.getFileList().get(i).getName(),
						new FileBody(new File(param.getFileList().get(i).getValue())));
			}
		}
		return multipartContent;
	}

}
