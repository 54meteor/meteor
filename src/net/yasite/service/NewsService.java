package net.yasite.service;

import java.util.List;

import net.yasite.api.BaseAPI;
import net.yasite.api.ListAPI;
import net.yasite.api.params.ListParams;
import net.yasite.dao.NewsDao;
import net.yasite.entity.NewsEntity;
import net.yasite.entity.NewsListEntity;
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
				if(newsListEntity != null 
						&& newsListEntity.getAlist() != null){
					if(page.equals("1")){
						((NewsDao)getDao(NewsEntity.class)).deleteAll();
					}
					((NewsDao)getDao(NewsEntity.class)).insertInTx(newsListEntity.getAlist());
				}
				return newsListEntity;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<NewsEntity> getDaoList() {
		return ((NewsDao)getDao(NewsEntity.class)).getAllList();
	}

}
