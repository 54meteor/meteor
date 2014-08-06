package net.yasite.model;

import net.yasite.entity.SocerListEntity;
import net.yasite.service.SocerListService;
import android.content.Context;

public class SocerModel extends Model {
	SocerListService socerService;
	public SocerModel(Context context){
		this.context = context;
		socerService = new SocerListService(context);
	}
	
	public SocerListEntity RequestSocerList(){
		return socerService.getSocerList();
	}
}
