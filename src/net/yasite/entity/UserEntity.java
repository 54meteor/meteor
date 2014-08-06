package net.yasite.entity;

import java.io.Serializable;

public class UserEntity implements Serializable {

	private long id;
	private String username;
	private String logined_at;
	private String avatar;
//	private SocialsListEntity socials;
	private String logined;
//	private NotifyEntity notify;
	private ErrorEntity error;
	private String mask;
	private String nickname;
	private String access_token;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLogined_at() {
		return logined_at;
	}
	public void setLogined_at(String logined_at) {
		this.logined_at = logined_at;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public ErrorEntity getError() {
		return error;
	}
	public void setError(ErrorEntity error) {
		this.error = error;
	}
	public String getLogined() {
		return logined;
	}
	public void setLogined(String logined) {
		this.logined = logined;
	}
	public String getMask() {
		return mask;
	}
	public void setMask(String mask) {
		this.mask = mask;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
}
