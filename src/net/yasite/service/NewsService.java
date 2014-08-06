package net.yasite.service;

import net.yasite.api.BaseAPI;
import net.yasite.api.ListAPI;
import net.yasite.api.params.ListParams;
import net.yasite.entity.NewsListEntity;
import android.content.Context;

public class NewsService extends BaseService {

	public NewsService(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public NewsListEntity getList(String page){
		ListParams pm = new ListParams();
		pm.setPage(page);
		BaseAPI api = new ListAPI(context, pm);
		try {
			if(api.doGet()){
				return (NewsListEntity)api.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
