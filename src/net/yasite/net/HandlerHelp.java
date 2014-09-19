package net.yasite.net;

import net.yasite.util.ActivityUtil;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;



public abstract class HandlerHelp {

	private Context context;
	private String error;

	private HandlerHelp() {

	}

	public HandlerHelp(Context context) {
		this.context = context;
	}

	/**
	 * 执行Handler
	 * @return
	 */
	public boolean execute() {
		return execute(true);
	}
	/**
	 * 
	 * @param hit 提示信息
	 * @param checkNetwork 是否检查网络情况 true 需要.false 不需要
	 * @return
	 */
	RequestThread t = new RequestThread();
	public boolean execute(boolean checkNetwork) {
		 // 检查网络情况
        if(checkNetwork && ActivityUtil.isNetworkAvailable(context)){
            t.setNetStatus(true);
        }else{
        	t.setNetStatus(false);
        }
        t.start();
        return true;
	}
	class RequestThread extends Thread{
		boolean netStatus = true;

		public void setNetStatus(boolean netStatus) {
			this.netStatus = netStatus;
		}

		@Override
		public void run() {
			Message msg = new Message();
			try {
				// 设置默认值
				msg.what = HttpConstant.MSG_SUCCESSED;
				if(netStatus){
					doTask(msg);
				}else{
					doTaskAsNoNetWork(msg);
				}
			} catch (Exception e) {
				e.printStackTrace();
				msg.what = HttpConstant.MSG_ERROR;
				error = e.getMessage() == null ? "网络连接超时!" : e.getMessage();
			}  finally {
				tHandler.sendMessage(msg);
			}
		}
	}
	
	Handler tHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			try {
				switch (msg.what) {
				case HttpConstant.MSG_SUCCESSED:
					updateUI();
					break;
				case HttpConstant.MSG_ERROR:
					error();
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				tHandler.removeMessages(msg.what);
				if(t != null){
					tHandler.removeCallbacks(t);
				}
			}
		}
	};


	/**
	 * 处理handler异常
	 */
	public void error() {
		if("服务器繁忙!网络连接超时!服务器异常!请求超时!系统出错!操作失败!".contains(error)){
			Toast.makeText(context, error, Toast.LENGTH_SHORT).show();
		}
	}
	/**
	 * handler
	 * 
	 * @param 更新UI
	 */
	
	public abstract void updateUI();

	/**
	 * 数据处理
	 * 
	 * @param msg
	 */
	public abstract void doTask(Message msg) throws Exception;
	/**
	 * 无网络时数据处理
	 * 
	 * @param msg
	 */
	public abstract void doTaskAsNoNetWork(Message msg) throws Exception;
}
