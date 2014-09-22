package net.yasite.entity;

import java.io.Serializable;
import java.util.List;

public class CartEntity implements Serializable {
	private List<GoodEntity> goodList;
	private String totalShopPrice;
	private String totalMarketPrice;
	private String lessPrice;
	private String goodsCount;
	public List<GoodEntity> getGoodList() {
		return goodList;
	}
	public void setGoodList(List<GoodEntity> goodList) {
		this.goodList = goodList;
	}
	public String getTotalShopPrice() {
		return totalShopPrice;
	}
	public void setTotalShopPrice(String totalShopPrice) {
		this.totalShopPrice = totalShopPrice;
	}
	public String getTotalMarketPrice() {
		return totalMarketPrice;
	}
	public void setTotalMarketPrice(String totalMarketPrice) {
		this.totalMarketPrice = totalMarketPrice;
	}
	public String getLessPrice() {
		return lessPrice;
	}
	public void setLessPrice(String lessPrice) {
		this.lessPrice = lessPrice;
	}
	public String getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(String goodsCount) {
		this.goodsCount = goodsCount;
	}
	
}
