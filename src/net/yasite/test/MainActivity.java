package net.yasite.test;

import net.yasite.adapter.GoodListAdapter;
import net.yasite.adapter.TestAdapter;
import net.yasite.entity.GoodListEntity;
import net.yasite.model.GoodModel;
import net.yasite.net.HandlerHelp;
import net.yasite.view.XListView;
import net.yasite.view.XListView.OnXListViewListener;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends BaseNewActivity implements OnXListViewListener{
	XListView listView;
	TestAdapter adapter;
	GoodModel goodModel;
	int pageNumber = 1;
	
	
	@Override
	public void onRefresh() {
		pageNumber = 1;
		new GoodListHandler(context).execute();
	}

	@Override
	public void onLoadMore() {
		new GoodListHandler(context).execute();
	}
	
	@Override
	public void setupView() {
		//仅能用于初始化组件，只有赋值操作
		listView = (XListView)findViewById(R.id.list_view);
		listView.setXListViewListener(this);
		listView.setFooterReady(true);
		listView.setPullLoadEnable(XListView.FOOTER_SHOW);
		
	}

	@Override
	public void setContent() {
		//有且仅有一行代码
		setContentView(R.layout.activity_main);
	}

	@Override
	public void setModel() {
		//实例化model，修改组件属性，判定控件，启动获取数据的线程
		adapter = new TestAdapter(context);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				if(position > 0){
					Intent it = new Intent(context,GoodInfoActivity.class);
					it.putExtra("id", adapter.getItem(position - 1).getGoods_id());
					startActivity(it);
				}
			}
		});
		listView.refresh(this);
	}

	@Override
	public boolean getIntentValue() {
		//默认永远返回true,如果需要判断Intent是否有值传过来，需要重写此方法
		return true;
	}
	
	class GoodListHandler extends HandlerHelp{
		GoodListEntity goodList;
		public GoodListHandler(Context context) {
			super(context);
			goodModel = new GoodModel(context);
		}

		@Override
		public void updateUI() {
			listView.stopRefresh();
			listView.stopLoadMore();
			if(goodList != null){
				if(goodList.getList() != null 
						&& goodList.getList().size() > 0){
					if(pageNumber == 1){
						adapter.setList(goodList.getList());
					}else{
						adapter.getList().addAll(goodList.getList());
					}
					pageNumber++;
					adapter.notifyDataSetChanged();
				}
			}
		}

		@Override
		public void doTask(Message msg) throws Exception {
			goodList = goodModel.RequestGoodList(pageNumber);
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			
		}
		
	}
}
