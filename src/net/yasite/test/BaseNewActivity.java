package net.yasite.test;

import net.yasite.util.ActivityUtil;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;


public abstract class BaseNewActivity extends FragmentActivity implements ActivityPageSetting{
	public View mNightView = null;
	public WindowManager mWindowManager;
	public Context context;
	
	
	@Override
	protected void onCreate(Bundle arg0) {
		mWindowManager = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(arg0);
		context = this;
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContent();
		if(getIntentValue()){
			setupView();
			setModel();
		}
	}
	
	protected void sendMsg(){
		ActivityUtil.showToast(context, "Intent的传值错误，请重试");
	}
	
	public int getScreen(boolean flag) {
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		if (flag) {
			return metrics.widthPixels;
		} else {
			return metrics.heightPixels;
		}
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}
	protected Button getButton(int id) {
		return (Button) findViewById(id);
	}
	@Override
	protected void onPause() {
		super.onPause();
	}

	protected ImageButton getImageButton(int id) {
		return (ImageButton) findViewById(id);
	}

	protected EditText getEdit(int id) {
		return (EditText) findViewById(id);
	}

	protected TextView getTextView(int id) {
		return (TextView) findViewById(id);
	}

	protected ListView getListView(int id) {
		return (ListView) findViewById(id);
	}

	protected ImageView getImageView(int id) {
		return (ImageView) findViewById(id);
	}
	protected GridView getGridView(int id){
	    return (GridView)findViewById(id);
	}
	protected CheckBox getCheckBox(int id) {
		return (CheckBox) findViewById(id);
	}
	protected RelativeLayout getRelativeLayout(int id) {
        return (RelativeLayout) findViewById(id);
    }
	protected LinearLayout getLinearLayout(int id) {
        return (LinearLayout) findViewById(id);
    }
	protected void setTextViewText(int resourceId,int StringId){
	    getTextView(resourceId).setText(getResources().getString(StringId));
	}
	protected void setTextViewText(int resourceId,String string){
        getTextView(resourceId).setText(string);
    }

	public void night() {
		WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT,
				WindowManager.LayoutParams.TYPE_APPLICATION,
				WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
				| WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
				PixelFormat.TRANSLUCENT);
		
		lp.gravity = Gravity.BOTTOM;// 可以自定义显示的位置
		lp.y = 10;
		if (mNightView == null) {
			mNightView = new TextView(this);
			mNightView.setBackgroundColor(0x80000000);
		}
		try{
			mWindowManager.addView(mNightView, lp);
		}catch(Exception ex){
			
		}

	}
	public void day(){
		try{
			if(mNightView != null){
				mWindowManager.removeView(mNightView);
			}
		}catch(Exception ex){
			
		}
	}
	public void pbShow(ProgressBar pb){
		if(pb != null){
			pb.setVisibility(View.VISIBLE);
		}
	}
	public void pbHide(ProgressBar pb){
		if(pb != null){
			pb.setVisibility(View.GONE);
		}
	}
}
