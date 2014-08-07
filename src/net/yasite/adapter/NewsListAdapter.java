package net.yasite.adapter;

import java.util.ArrayList;
import java.util.List;

import net.yasite.entity.NewsEntity;
import net.yasite.test.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsListAdapter extends BaseAdapter {
	List<NewsEntity> list;
	Context context;
	
	
	public List<NewsEntity> getList() {
		return list;
	}
	public void setList(List<NewsEntity> list) {
		this.list = list;
	}
	public NewsListAdapter(Context context){
		this.context = context;
		list = new ArrayList<NewsEntity>();
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public NewsEntity getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		ViewHolder mViewHolder;
		if(null == convertView){
			mViewHolder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
			this.setupChildViews(convertView, mViewHolder);
			convertView.setTag(mViewHolder);
		} else{
			mViewHolder = (ViewHolder) convertView.getTag();
		}
			setChildViewData(mViewHolder, position, getItem(position));
		return convertView;
	}
	
	
	private void setChildViewData(ViewHolder mViewHolder, int position,
			NewsEntity item) {
		mViewHolder.nid.setText(item.getId());
		mViewHolder.title.setText(item.getTitle());
		mViewHolder.desc.setText(item.getDesc());
		
	}
	private void setupChildViews(View convertView, ViewHolder mViewHolder){
		mViewHolder.nid = (TextView)convertView.findViewById(R.id.nid);
		mViewHolder.title = (TextView)convertView.findViewById(R.id.title);
		mViewHolder.desc = (TextView)convertView.findViewById(R.id.desc);
	}
	
	static class ViewHolder{
		private TextView nid;
		private TextView title;
		private TextView desc;
	}

}
