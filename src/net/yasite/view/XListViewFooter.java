package net.yasite.view;

import net.yasite.test.R;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;



public class XListViewFooter extends LinearLayout
{
	public final static int STATE_NORMAL = 0;
	public final static int STATE_READY = 1;
	public final static int STATE_LOADING = 2;
	public final static int STATE_NOTDATA = 3;
	public final static int STATE_WAIT = 4;
	private Context mContext;

	private View mContentView;
	private View mProgressBar;
	private TextView mHintView;

	public XListViewFooter(Context context)
	{
		super(context);
		initView(context);
	}

	public XListViewFooter(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		initView(context);
	}

	public void setState(int state)
	{
		mHintView.setTextColor(Color.BLACK);
		mProgressBar.setVisibility(View.INVISIBLE);
		switch (state)
		{
		default:
			mHintView.setVisibility(View.VISIBLE);
			mHintView.setText(R.string.xlistview_footer_hint_normal);
			break;
		case STATE_READY:
			mHintView.setVisibility(View.VISIBLE);
			mHintView.setText(R.string.xlistview_footer_hint_ready);
			break;
		case STATE_LOADING:
			mProgressBar.setVisibility(View.VISIBLE);
			mHintView.setText(R.string.xlistview_header_hint_loading);
			break;
		case STATE_NOTDATA:
			mProgressBar.setVisibility(View.INVISIBLE);
			mHintView.setText(R.string.xlistview_footer_hint_notdata);
			break;
		case STATE_WAIT:
			mHintView.setVisibility(View.VISIBLE);
			mHintView.setText(R.string.xlistview_footer_hint_notdata);
			break;
		}
	}

	public void setBottomMargin(int height)
	{
		if (height < 0)
			return;
		LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mContentView.getLayoutParams();
		lp.bottomMargin = height;
		mContentView.setLayoutParams(lp);
	}

	public int getBottomMargin()
	{
		LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mContentView.getLayoutParams();
		return lp.bottomMargin;
	}

	/**
	 * normal status
	 */
	public void normal()
	{
		mHintView.setVisibility(View.VISIBLE);
		mProgressBar.setVisibility(View.GONE);
	}

	/**
	 * loading status
	 */
	public void loading()
	{
		mHintView.setVisibility(View.GONE);
		mProgressBar.setVisibility(View.VISIBLE);
	}

	private void initView(Context context)
	{
		mContext = context;
		LinearLayout moreView = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.xlistview_footer, null);
		addView(moreView);
		moreView.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

		mContentView = moreView.findViewById(R.id.xlistview_footer_content);
		mProgressBar = moreView.findViewById(R.id.xlistview_footer_progressbar);
		mHintView = (TextView) moreView.findViewById(R.id.xlistview_footer_hint_textview);
	}

}
