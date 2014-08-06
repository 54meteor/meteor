package net.yasite.service;

import net.yasite.api.BaseAPI;
import net.yasite.api.SocerListAPI;
import net.yasite.api.params.SocerListParams;
import net.yasite.entity.SocerListEntity;
import android.content.Context;

public class SocerListService extends BaseService {

	public SocerListService(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	
	public SocerListEntity getSocerList(){
		SocerListParams pm = new SocerListParams();
		BaseAPI api = new SocerListAPI(context, pm);
		try {
			if(api.doGet()){
				return (SocerListEntity)api.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
