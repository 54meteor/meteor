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

	public final static String CTYPE = "2";
	public final static String VERSION = "1.0";
	public final static String ACCOUNTTYPE = "2";
	
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
	
	//************************api 状态常量 start*********************************//
	/**
	 * 用户以或密码不正确
	 */
	public static final int INVALID_USER = 60001;
	
	/**
	 * 手机号码格式不对
	 */
	public static final int MOBILE_FORMAT_WRONG = 60007;
	
	/**
	 * 该用户已删除 
	 */
	public static final int DELETE_USER = 60009;
	
	/**
	 * 班级不存在
	 */
	
	public static final int NOT_EXIST_CLASS = 60016;

	/**
	 * 学生不存在
	 */
	public static final int NOT_EXIST_STUDENT = 60018;
	/**
	 * 老师不存在
	 */
	public static final int NOT_EXIST_TEACHER = 60019;
	
	/**
	 * 登录API标识
	 */
	public static final int LOGIN_SUBCLESS = 0X001;
	
	/**
	 * 家长不存在
	 */
	public static final int NOT_EXIST_PARENTS = 60035;
	
	/**
	 * 学校不存在
	 */
	public static final int NOT_EXIST_SCHOOL = 60038;
	/**
	 * 老师和班级的关系不存在
	 */
	public static final int NOT_EXIST_TCID = 60039;
	
	//************************api 状态常量 end*********************************//
}
