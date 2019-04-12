package com.hl.recruit.util;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.ArrayList;
import java.util.List;

public class Page {
	private int pageIndex = 0;
	private int pageSize = 0;
	private String sortField = null;
	private String sortOrder = null;
	private int totalCount = 0;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public PageBounds toPageBounds(){

		PageBounds pageBounds = new PageBounds(this.pageIndex+1,this.pageSize) ;
		if(this.sortField!=null&&!this.sortField.equals("")){
			Order order = new Order(this.propToField(this.sortField),Order.Direction.fromString(this.sortOrder),"");
			ArrayList<Order> orders = new ArrayList<Order>();
			orders.add(order);
			pageBounds.setOrders(orders);
		}
		return pageBounds;
	}
	
	public String propToField(String prop){
		if(prop!=null) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < prop.length(); i++) {
				if(Character.isUpperCase(prop.charAt(i))) {
					sb.append("_");
				}
				sb.append(Character.toUpperCase(prop.charAt(i)));
			}
			return sb.toString();
		}
		return null;
	}
	public int totalCount(List list){
		if(list!= null){
			totalCount= list.size();
			return this.getTotalCount() ;
		}
		return 0;
	}

	public void setTotalCount(int count){
		this.totalCount = count;
	}
	public int getTotalCount(){
		return this.totalCount ;
	}
}
