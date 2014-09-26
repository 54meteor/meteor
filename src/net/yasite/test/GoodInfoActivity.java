package net.yasite.test;

import net.yasite.entity.GoodEntity;
import net.yasite.model.GoodModel;
import net.yasite.net.HandlerHelp;
import net.yasite.util.ActivityUtil;
import android.content.Context;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

public class GoodInfoActivity extends BaseNewActivity {
	ImageView thumb;
	TextView name;
	TextView market_price;
	TextView shop_price;
	String id;
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
		// TODO Auto-generated method stub
		setContentView(R.layout.goods_item);
	}

	@Override
	public void setModel() {
		goodModel = new GoodModel(context);
		new GoodInfoHandler(context).execute();
	}

	@Override
	public boolean getIntentValue() {
		id = getIntent().getStringExtra("id");
		if(id != null && !id.equals("")){
			return true;
		}else{
			ActivityUtil.showToast(context, "未找到商品");
			return false;
		}
	}
	
	class GoodInfoHandler extends HandlerHelp{

		public GoodInfoHandler(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void updateUI() {
			// TODO Auto-generated method stub
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
				
			}else{
				ActivityUtil.showToast(context, "未找到商品");
			}
		}

		@Override
		public void doTask(Message msg) throws Exception {
			// TODO Auto-generated method stub
			goodEntity = goodModel.RequestGoodInfo(id);
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			// TODO Auto-generated method stub
			
		}
		
	}

}
