package net.yasite.adapter;

import java.util.ArrayList;
import java.util.List;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import net.yasite.adapter.NewsListAdapter.ViewHolder;
import net.yasite.entity.GoodEntity;
import net.yasite.entity.NewsEntity;
import net.yasite.test.BaseApplication;
import net.yasite.test.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GoodListAdapter extends BaseAdapter {
	Context context;
	List<GoodEntity> list;
	private ImageLoader mImageLoader;
	private DisplayImageOptions options;
	
	public GoodListAdapter(Context context){
		this.context = context;
		list = new ArrayList<GoodEntity>();
		mImageLoader = BaseApplication.initImageLoader(context);
		options = new DisplayImageOptions.Builder()
		.bitmapConfig(Bitmap.Config.RGB_565)
		.showStubImage(R.drawable.ic_launcher)
        .showImageForEmptyUri(R.drawable.ic_launcher)
        .showImageOnFail(R.drawable.ic_launcher)
		.cacheInMemory(true)
		.cacheOnDisc(true)
		.build();
	}
	
	

	public List<GoodEntity> getList() {
		return list;
	}



	public void setList(List<GoodEntity> list) {
		this.list = list;
	}



	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public GoodEntity getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		ViewHolder mViewHolder;
		if(null == convertView){
			mViewHolder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(R.layout.goods_item, null);
			this.setupChildViews(convertView, mViewHolder);
			convertView.setTag(mViewHolder);
		} else{
			mViewHolder = (ViewHolder) convertView.getTag();
		}
			setChildViewData(mViewHolder, position, getItem(position));
		return convertView;
	}
	
	private void setChildViewData(ViewHolder mViewHolder, int position,
			GoodEntity item) {
		if(item.getGoods_name() != null){
			mViewHolder.name.setText(item.getGoods_name());
		}else{
			mViewHolder.name.setText("");
		}
		
		if(item.getMarket_price() != null){
			mViewHolder.market_price.setText("市场价：" + item.getMarket_price());
		}else{
			mViewHolder.name.setText("");
		}
		if(item.getShop_price() != null){
			mViewHolder.promote_price.setText("本店价：" + item.getShop_price());
		}else{
			mViewHolder.name.setText("");
		}
		
		if(item.getGoods_thumb() != null && !item.getGoods_thumb().equals("")){
			mImageLoader.displayImage(item.getGoods_thumb(),
					mViewHolder.thumb, options);
		}else{
			mImageLoader.displayImage("drawable://" + R.drawable.ic_launcher, mViewHolder.thumb);
		}
		
	}
	private void setupChildViews(View convertView, ViewHolder mViewHolder){
		mViewHolder.name = (TextView)convertView.findViewById(R.id.name);
		mViewHolder.market_price = (TextView)convertView.findViewById(R.id.market_price);
		mViewHolder.promote_price = (TextView)convertView.findViewById(R.id.promote_price);
		mViewHolder.thumb = (ImageView)convertView.findViewById(R.id.thumb);
	}
	
	static class ViewHolder{
		private TextView name;
		private TextView market_price;
		private TextView promote_price;
		private ImageView thumb;
	}

}
