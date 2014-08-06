package net.yasite.entity;

import java.io.Serializable;
import java.util.List;

public class NewsListEntity implements Serializable {

	private List<NewsEntity> alist;
	private String page;
	private String totalPage;
	private String perSize;
	public List<NewsEntity> getAlist() {
		return alist;
	}
	public void setAlist(List<NewsEntity> alist) {
		this.alist = alist;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}
	public String getPerSize() {
		return perSize;
	}
	public void setPerSize(String perSize) {
		this.perSize = perSize;
	}
	
	
	
}
