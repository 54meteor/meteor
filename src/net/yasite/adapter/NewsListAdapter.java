package net.yasite.adapter;

import java.util.ArrayList;
import java.util.List;

import net.yasite.entity.NewsEntity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		return null;
	}

}
