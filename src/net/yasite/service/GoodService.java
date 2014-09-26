package net.yasite.service;

import net.yasite.api.BaseAPI;
import net.yasite.api.GoodInfoAPI;
import net.yasite.api.GoodListAPI;
import net.yasite.api.params.GoodInfoParams;
import net.yasite.api.params.GoodListParams;
import net.yasite.entity.GoodEntity;
import net.yasite.entity.GoodListEntity;
import android.content.Context;

public class GoodService extends BaseService {

	public GoodService(Context context) {
		super(context);
	}
	
	public GoodListEntity getGoodList(int page){
		GoodListParams pm = new GoodListParams();
		pm.setPage(Integer.toString(page));
		BaseAPI api = new GoodListAPI(context, pm);
		try {
			if(api.doGet()){
				return (GoodListEntity)api.getHandleResult(); 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public GoodEntity getGoodInfo(String id){
		GoodInfoParams pm = new GoodInfoParams();
		pm.setId(id);
		BaseAPI api = new GoodInfoAPI(context, pm);
		try {
			if(api.doGet()){
				return (GoodEntity)api.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
