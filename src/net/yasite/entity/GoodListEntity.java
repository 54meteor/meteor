package net.yasite.entity;

import java.io.Serializable;
import java.util.List;

public class GoodListEntity implements Serializable {
	private List<GoodEntity> list;

	public List<GoodEntity> getList() {
		return list;
	}

	public void setList(List<GoodEntity> list) {
		this.list = list;
	}
	
}
