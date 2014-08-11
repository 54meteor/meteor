package net.yasite.test;

import net.yasite.adapter.NewsListAdapter;
import net.yasite.entity.NewsListEntity;
import net.yasite.entity.SocerListEntity;
import net.yasite.model.NewsModel;
import net.yasite.model.PostTmpModel;
import net.yasite.model.SocerModel;
import net.yasite.model.UploadModel;
import net.yasite.net.HandlerHelp;
import net.yasite.view.XListView;
import net.yasite.view.XListView.OnXListViewListener;
import android.content.Context;
import android.os.Message;

public class MainActivity extends BaseNewActivity implements OnXListViewListener{
	NewsModel newsModel;
	NewsListEntity newsListEntity;
	XListView listView;
	NewsListAdapter adapter;
	SocerModel socerModel;
	SocerListEntity socerListEntity;
	PostTmpModel pModel;
	int pageNumber = 1;
	
	
	@Override
	public void onRefresh() {
		pageNumber = 1;
		// TODO Auto-generated method stub
		new ListHandler(context,pageNumber).execute();
//		new SocerListHandler(context).execute();
	}

	@Override
	public void onLoadMore() {
		new ListHandler(context,pageNumber).execute();
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
		newsModel = new NewsModel(context);
		socerModel = new SocerModel(context);
		adapter = new NewsListAdapter(context);
		listView.setAdapter(adapter);
		pModel = new PostTmpModel(context);
		listView.refresh(this);
	}

	@Override
	public boolean getIntentValue() {
		//默认永远返回true,如果需要判断Intent是否有值传过来，需要重写此方法
		return true;
	}
	
	class ListHandler extends HandlerHelp{
		String page;

		public ListHandler(Context context,int page) {
			super(context);
			this.page = Integer.toString(page);
		}

		@Override
		public void updateUI() {
//			listView.stopRefresh();
//			listView.stopLoadMore();
//			if(newsListEntity != null){
//				if(newsListEntity.getAlist() != null 
//						&& newsListEntity.getAlist().size() > 0){
//					if(pageNumber == 1){
//						adapter.setList(newsListEntity.getAlist());
//					}else{
//						adapter.getList().addAll(newsListEntity.getAlist());
//					}
//					pageNumber++;
//					adapter.notifyDataSetChanged();
//					if(newsListEntity.getPage().equals(newsListEntity.getTotalPage())){
//						listView.setPullLoadEnable(XListView.FOOTER_RETAIN);
//					}
//				}
//			}
		}

		@Override
		public void doTask(Message msg) throws Exception {
//			newsListEntity = newsModel.RequestList(page);
			UploadModel model = new UploadModel(context);
			model.RequestUpload("a", "b");
		}

		@Override
		public void doTaskAsNoNetWork(Message msg) throws Exception {
			System.out.println("adfafda");
		}
		
	}

	

	
	
//	class SocerListHandler extends HandlerHelp{
//
//		public SocerListHandler(Context context) {
//			super(context);
//			// TODO Auto-generated constructor stub
//		}
//
//		@Override
//		public void updateUI() {
//			if(socerListEntity != null){
//				System.out.println("size:" + socerListEntity.getList().get(0).getName());
//				System.out.println(socerListEntity.getList().get(0).getRankings().size());
//			}else{
//				System.out.println("dddddddd");
//			}
//		}
//
//		@Override
//		public void doTask(Message msg) throws Exception {
//			// TODO Auto-generated method stub
//			pModel.RequestPost("12451515793759817595");
//			socerListEntity = socerModel.RequestSocerList();
//		}
//
//		@Override
//		public void doTaskAsNoNetWork(Message msg) throws Exception {
//			// TODO Auto-generated method stub
//			
//		}
//		
//	}
	

}
