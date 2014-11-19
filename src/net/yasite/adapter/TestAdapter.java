package net.yasite.adapter;

import java.util.ArrayList;
import java.util.List;

import net.yasite.entity.GoodEntity;
import net.yasite.entity.NewsEntity;
import net.yasite.test.R;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TestAdapter extends YasiteAdapter {
	List<GoodEntity> objList = new ArrayList<GoodEntity>();
	public TestAdapter(Context context) {
		super(context);
		setImageLoader();
	}
	
	public TestAdapter(Context context,List<NewsEntity> newsList) {
		super(context);
		setImageLoader();
	}
	
	public List<GoodEntity> getList() {
		return objList;
	}
	public void setList(List<GoodEntity> list) {
		this.objList = list;
	}

	@Override
	public int getCount() {
		return objList.size();
	}

	@Override
	public GoodEntity getItem(int positon) {
		return (GoodEntity)objList.get(positon);
	}

	@Override
	public long getItemId(int positon) {
		return positon;
	}

	@Override
	protected void setupChildViews(View convertView, ViewHolder mViewHolder) {
		ViewHolderTest test = (ViewHolderTest)mViewHolder;
		test.name = (TextView)convertView.findViewById(R.id.name);
		test.market_price = (TextView)convertView.findViewById(R.id.market_price);
		test.promote_price = (TextView)convertView.findViewById(R.id.promote_price);
		test.thumb = (ImageView)convertView.findViewById(R.id.thumb);
	}

	@Override
	protected void setChildViewData(ViewHolder mViewHolder, int position, Object obj) {
		if(obj instanceof GoodEntity){
			GoodEntity item = (GoodEntity)obj;
			ViewHolderTest test = (ViewHolderTest)mViewHolder;
			if(item.getGoods_name() != null){
				test.name.setText(item.getGoods_name());
			}else{
				test.name.setText("");
			}
			
			if(item.getMarket_price() != null){
				test.market_price.setText("市场价：" + item.getMarket_price());
			}else{
				test.name.setText("");
			}
			if(item.getShop_price() != null){
				test.promote_price.setText("本店价：" + item.getShop_price());
			}else{
				test.name.setText("");
			}
			
			if(item.getGoods_thumb() != null && !item.getGoods_thumb().equals("")){
				mImageLoader.displayImage(item.getGoods_thumb(),
						test.thumb, options);
			}else{
				mImageLoader.displayImage("drawable://" + R.drawable.ic_launcher, test.thumb);
			}
		}
	}
	class ViewHolderTest extends ViewHolder{
		private TextView name;
		private TextView market_price;
		private TextView promote_price;
		private ImageView thumb;
	}
	@Override
	protected ViewHolder setHolder() {
		return new ViewHolderTest();
	}

	@Override
	protected void setLayoutResource(int position) {
		// TODO Auto-generated method stub
		layoutId = R.layout.goods_item;
	}
}
