package net.yasite.test;

import android.content.Context;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;
import net.yasite.entity.GoodEntity;
import net.yasite.model.GoodModel;
import net.yasite.net.HandlerHelp;
import net.yasite.util.ActivityUtil;

public class GoodInfoActivity extends BaseNewActivity {
	String id;
	ImageView thumb;
	TextView name;
	TextView market_price;
	TextView shop_price;
	GoodModel goodModel;
	GoodEntity goodEntity;
	@Override
	public void setupView() {
		thumb = getImageView(R.id.thumb);
		name = getTextView(R.id.name);
		market_price = getTextView(R.id.market_price);
		shop_price = getTextView(R.id.promote_price);
	}

	@Override
	public void setContent() {
		setContentView(R.layout.goods_item);
	}

	@Override
	public void setModel() {
		goodModel = new GoodModel(context);
		new GoodInfoHandler(context).execute();
	}

	@Override
	public boolean getIntentValue() {
		if(getIntent().getStringExtra("id") != null){
			id = getIntent().getStringExtra("id");
			return true;
		}else{
			ActivityUtil.showToast(context, "未找到商品信息");
			return false;
		}
	}
	
	
	class GoodInfoHandler extends HandlerHelp{

		public GoodInfoHandler(Context context) {
			super(context);
		}

		@Override
		public void updateUI() {
			if(goodEntity != null){
				if(goodEntity.getGoods_name() != null){
					name.setText(goodEntity.getGoods_name());
				}else{
					name.setText("");
				}
				if(goodEntity.getMarket_price() != null){
					market_price.setText(goodEntity.getMarket_price());
				}else{
					market_price.setText("");
				}
			}
		}

		@Override
		public void doTask(Message msg) throws Exception {
			goodEntity = goodModel.RequestGoodInfo(id);
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub
			
		}
		
	}

}
