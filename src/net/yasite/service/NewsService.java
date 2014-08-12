package net.yasite.service;

import net.yasite.api.BaseAPI;
import net.yasite.api.ListAPI;
import net.yasite.api.params.ListParams;
import net.yasite.dao.UserDao;
import net.yasite.entity.NewsListEntity;
import net.yasite.entity.UserEntity;
import android.content.Context;

public class NewsService extends BaseService {

	public NewsService(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public NewsListEntity getList(String page){
		NewsListEntity newsListEntity = new NewsListEntity();
		ListParams pm = new ListParams();
		pm.setPage(page);
		BaseAPI api = new ListAPI(context, pm);
		try {
			if(api.doGet()){
				newsListEntity = (NewsListEntity)api.getHandleResult();
				return newsListEntity;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
