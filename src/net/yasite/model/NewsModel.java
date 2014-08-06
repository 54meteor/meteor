package net.yasite.model;

import net.yasite.entity.NewsListEntity;
import net.yasite.service.NewsService;
import android.content.Context;

public class NewsModel extends Model {
	NewsService newsService;
	
	public NewsModel(Context context){
		newsService = new NewsService(context);
	}
	
	public NewsListEntity RequestList(String page){
		return newsService.getList(page);
	}
}
