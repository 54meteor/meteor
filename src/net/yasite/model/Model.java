package net.yasite.model;


import java.util.Random;

import net.yasite.test.R;
import net.yasite.util.ActivityUtil;
import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public abstract class Model {
	public Context context;

	// public UserService userService;

	public String editText(EditText et) {
	    et.requestFocus();
		return et.getText().toString().trim();
	}

	public String textView(TextView tv) {
		return tv.getText().toString();
	}

	public void reportToast(String message) {
		Toast toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
		toast.show();
	}

	public boolean checkLength(String name,int length,String message){
	    if(!CFunction.checkTextMax(name, length)){
	        return true;
	    }else{
	        ActivityUtil.showToast(context, message);
	        return false;
	    }
	}
	public boolean checkEmpty(String name,int length,String message){
	    if(!name.trim().equals("")){
	        return true;
	    }else{
	        ActivityUtil.showToast(context, message);
	        return false;
	    }
	}
	/**
	 * 查密码正确性  -------------------------新注释
	 * 
	 * */
	public boolean checkPwd(String pwd) {
//		if (pwd.equals("")) {
//			reportToast(context.getResources().getString(R.string.pwd_null));
//			return false;
//		}
//		if (CFunction.checkTextMin(pwd, 6)) {
//			reportToast(context.getResources().getString(R.string.pwd_error_min));
//			return false;
//		}
//		if (CFunction.checkTextMax(pwd, 16)) {
//            reportToast(context.getResources().getString(R.string.pwd_error_max));
//            return false;
//        }
		return true;
	}
	public boolean checkNewPwd(String pwd) {
        if (pwd.equals("")) {
            reportToast("请输入您的新密码");
            return false;
        }
//        if (CFunction.checkTextMin(pwd, 6)) {
//            reportToast(context.getResources().getString(R.string.pwd_error_min));
//            return false;
//        }
//        if (CFunction.checkTextMax(pwd, 16)) {
//            reportToast(context.getResources().getString(R.string.pwd_error_max));
//            return false;
//        }
        return true;
    }
	public boolean checkPwdConfi(String pwd) {
        if (pwd.equals("")) {
            reportToast("请输入您的确认密码");
            return false;
        }
//        if (CFunction.checkTextMin(pwd, 6)) {
//            reportToast(context.getResources().getString(R.string.pwd_error_min));
//            return false;
//        }
//        if (CFunction.checkTextMax(pwd, 50)) {
//            reportToast(context.getResources().getString(R.string.pwd_error_max));
//            return false;
//        }
        return true;
    }
	public boolean checkPwdLocal(String pwd) {
        if (pwd.equals("")) {
            reportToast("请输入当前密码");
            return false;
        }
//        if (CFunction.checkTextMin(pwd, 6)) {
//            reportToast(context.getResources().getString(R.string.pwd_error_min));
//            return false;
//        }
//        if (CFunction.checkTextMax(pwd, 50)) {
//            reportToast(context.getResources().getString(R.string.pwd_error_max));
//            return false;
//        }
        return true;
    }
	  /**
     * 验证密码一致性信息
     */
    public boolean checkInfo(String pwd,String verify){
    	boolean bool = false;
        if(pwd.equals(verify)){
            bool = true;
        }else{
            reportToast("确认密码和密码必须相同 ");
            bool = false;
        }
        return bool;
    }

	public boolean checkPhoneFromAddress(String phoneNum) {
	
		return true;
	}

	public void init() {
		
	}
	private static Random randGen = null;
    private static char[] numbersAndLetters = null;

    public static final String randomString(int length) {
             if (length < 1) {
                 return null;
             }
             if (randGen == null) {
                    randGen = new Random();
                    numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz" +
                       "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
                     }
             char [] randBuffer = new char[length];
             for (int i=0; i<randBuffer.length; i++) {
                 randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
             }
             return new String(randBuffer);
    }
}
