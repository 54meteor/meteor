package net.yasite.entity;

import java.io.Serializable;
import java.util.List;

public class SocerListEntity implements Serializable {
	private List<TotalSocerEntity> list;

	public List<TotalSocerEntity> getList() {
		return list;
	}

	public void setList(List<TotalSocerEntity> list) {
		this.list = list;
	}
	
}
