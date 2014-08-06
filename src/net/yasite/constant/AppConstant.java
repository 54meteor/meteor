package net.yasite.constant;

import java.util.ArrayList;
import java.util.List;

import android.os.Environment;


public class AppConstant {
	public static final int SMALLFONT = 75;
	public static final int NORMALFONT = 115;
	public static final int LARGEFONT = 150;
	
	public static int FONTSIZE = NORMALFONT;
	
	public static final int NIGHTMODE = 2;
	public static final int DAYMODE = 1;
	public static int VIDEOMODE = DAYMODE;
	public static int LIGHT = 255;
	public static Boolean LIGHT_AUTO = false;
	
	
	public static final String ROOT = Environment.getExternalStorageDirectory()
			.getAbsolutePath();

	public static final String APPS = "/com.dongqiudi.news/";
	public static final String PATH = ROOT + APPS;
	
	public static int msgNum = 0;
	public static final int VERSIONCODE = 29;
	public static final String VERSIONNAME = "2.2.5";
	public static final String SENDMESSAGE = "O4G0qZqHAp6qGmO87GCqh32b";
	public static final String QQ_ID = "100567460";
	public static final String QQ_KEY = "41c3b5c24c2b6b1b14e10be44fce469b";
	public static final int NEWS = 1;
	public static final int VIDEO = 3;
	public static final int THREAD = 5;
	public static boolean atttion = true;
	public static final String LEAGUE_MATCH = "ls";
	public static final String CUP_IN_COUNTRY = "gnbs";
	public static final String CUP_OUT_COUNTRY = "gjbs";
	public static final String COUNTRY = "gjd";
	public static final String DEEP = "736,745,754";
	public static final String TOPIC = "734,735,737,738,739,740,741,748,752,753";
	public static final String PLAYER = "744";
	public static final String LEISURE = "747,751";
	
	public static final String FAVOURITE_NEWS = "news";
	public static final String FAVOURITE_VIDEO = "video";
	public static final String FAVOURITE_THREAD = "topics";
	
	public static final String FAVOURITE_CREATE = "create";
	public static final String FAVOURITE_DESTROY = "destroy";
	
	public static final String FAVOURITE_TOPIC_CREATE = "topics/create";
	public static final String FAVOURITE_TOPIC_DESTROY = "topics/destroy";
	
}
