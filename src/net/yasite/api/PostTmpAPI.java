package net.yasite.api;

import java.util.List;

import net.yasite.api.params.Urls;

import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

public class PostTmpAPI extends BaseAPI {

	public PostTmpAPI(Context context, List<NameValuePair> pm) {
		super(context, pm);
		setMethod(Urls.WEB_SERVER_PATH + Urls.API+ Urls.postTmp);
	}

	@Override
	public Object handlerResult(JSONObject json) throws JSONException {
		return null;
	}

}
