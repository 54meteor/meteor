package net.yasite.test;

import android.R.mipmap;
import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.StrictMode;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

public class BaseApplication extends Application{
	/**
     * It is possible to keep a static reference across the
     * application of the image loader.
     */
//    private static ImageLoader imageManager;
    public static final boolean DEBUG = true;
    public static final String TOKEN = "token";
	@Override
	public void onCreate(){
		try{
			super.onCreate();
			ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
			.denyCacheImageMultipleSizesInMemory()
			.memoryCacheExtraOptions(768, 1280)
			.memoryCache(new UsingFreqLimitedMemoryCache(5 * 1024 * 1024))
			.memoryCacheSize(5 * 1024 * 1024)
			.discCacheSize(50 * 1024 * 1024)
			.discCacheFileNameGenerator(new Md5FileNameGenerator())
			.threadPoolSize(5)
			.threadPriority(Thread.NORM_PRIORITY - 1)
			.tasksProcessingOrder(QueueProcessingType.LIFO)
			.build();
			// 初始化ImageLoader的与配置。
			mImageLoader.init(config);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	public static ImageLoader mImageLoader = ImageLoader.getInstance();
	public static ImageLoader initImageLoader(Context context){
		mImageLoader.clearMemoryCache();
		return mImageLoader;
	}
	
}
