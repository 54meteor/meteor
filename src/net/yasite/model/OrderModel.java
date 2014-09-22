package net.yasite.model;

import android.content.Context;

public class OrderModel extends Model {
	public OrderModel(Context context){
		this.context = context;
	}
	
	public void createOrder(){
		if(isLogin()){
			if(isAddressInfo()){
				//生成订单
			}
		}
	}
	
	private boolean isLogin(){
		return true;
	}
	private boolean isAddressInfo(){
		return true;
	}
	
}

