package net.yasite.api;


import net.yasite.api.params.GoodListParams;
import net.yasite.api.params.Urls;
import net.yasite.entity.GoodListEntity;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.google.gson.Gson;

public class GoodListAPI extends BaseAPI {

	public GoodListAPI(Context context, GoodListParams pm) {
		super(context, pm);
		setMethod(Urls.WEB_SERVER_PATH + Urls.EC 
				+ Urls.goodsList + "?page=" + pm.getPage());
	}

	@Override
	public GoodListEntity handlerResult(JSONObject json) throws JSONException {
		return new Gson().fromJson(json.toString(), GoodListEntity.class);
	}

}
