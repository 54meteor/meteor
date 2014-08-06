package net.yasite.entity;

public class ErrorEntity {
	private int errCode;
	private String errMesg;
	private String message;
	private UserEntity params;
	public int getErrCode() {
		return errCode;
	}
	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}
	public String getErrMesg() {
		return errMesg;
	}
	public void setErrMesg(String errMesg) {
		this.errMesg = errMesg;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UserEntity getParams() {
		return params;
	}
	public void setParams(UserEntity params) {
		this.params = params;
	}
	
	
}
