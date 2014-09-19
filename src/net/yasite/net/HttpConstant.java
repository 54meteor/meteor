package net.yasite.net;


/**
 * 
 * Desc:http请求常量类
 * Date:2013-3-7
 * Author:admin
 */
public class HttpConstant {
	
    public static final int CONNECTION_TIMEOUT = 30 * 1000;

    public static final int DEFAULT_TIMEOUT = 30 * 1000;

    public static final int MAX_TIMEOUT = 60 * 1000;

	public static final String DUG_TYPE_INFO = "INFO";
	public static final String DUG_TYPE_ERROR = "ERROR";

	// handler Mesaage status 常量
	/**
	 * 处理http请求结果常量
	 * 成功
	 */
	public static final int MSG_SUCCESSED = 0x200;
	/**
	 * 处理http请求结果常量
	 * 失败
	 */
	public static final int MSG_FAILED = 0x500;
	/**
	 * 处理http请求结果常量
	 * 异常
	 */
	public static final int MSG_ERROR = 0X600;
	/**
	 * 处理http请求结果常量
	 * 异常
	 */
	public static final int MSG_ERROR_DEFINED = 0X700;
	
	//http statuc  常量
	/**
	 * http请求常量
	 * 请求成功
	 */
	public static final int HTTP_SUCCESSED = 20000;
	/**
	 * http请求常量
	 * 请求失败
	 */
	public static final int HTTP_FAILED = 30000;
	
	/**
	 * 自定义异常
	 */
	public static final int HTTP_CUSTOM_ERROR = 4000;
	
}
