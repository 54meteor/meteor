package net.yasite.net;

import android.util.Log;

public class GeneralException extends Throwable {
	private String errorMsg;
	private int errorStatus;
	public int getErrorStatus() {
		return errorStatus;
	}

	public void setErrorStatus(int errorStatus) {
		this.errorStatus = errorStatus;
	}

	public GeneralException() {
		super();
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public GeneralException(String errorMsg) {
		super(errorMsg);
		this.errorMsg = errorMsg;
		Log.e(HttpConstant.DUG_TYPE_ERROR, errorMsg);
	}
	public GeneralException(String errorMsg,int errorStatus) {
		super(errorMsg);
		this.errorMsg = errorMsg;
		this.errorStatus = errorStatus;
		Log.e(HttpConstant.DUG_TYPE_ERROR, errorMsg);
	}

}
