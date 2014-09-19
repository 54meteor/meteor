package net.yasite.model;

import net.yasite.entity.GoodListEntity;
import net.yasite.service.GoodService;
import android.content.Context;

public class GoodModel extends Model {
	
	GoodService goodService;
	
	public GoodModel(Context context){
		this.context = context;
		goodService = new GoodService(context);
	}
	
	
	public GoodListEntity RequestGoodList(int page){
		return goodService.getGoodList(page);
	}
}
