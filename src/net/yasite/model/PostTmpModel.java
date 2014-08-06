package net.yasite.model;

import net.yasite.service.PostTmpService;
import android.content.Context;

public class PostTmpModel extends Model {
	PostTmpService pService;
	
	public PostTmpModel(Context context){
		this.context = context;
		pService = new PostTmpService(context);
	}
	public void RequestPost(String tmp){
		pService.submitinfo(tmp);
	}
	
}
