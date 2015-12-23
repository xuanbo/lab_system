package com.whut.lab.web.model;

import java.util.List;

/**
 * 分页辅助类
 * @author xuan
 *
 */
public class Page<T> {

	private List<T> list;
	//总的记录数
	private long totalCount;
	//当前页
	private int current;
	//每页显示数目
	private int size;
	//总页数
	@SuppressWarnings("unused")
	private int totalPage;
	
	public Page() {
		super();
	}
	
	public Page(List<T> list, long totalCount, int current, int size,
			int totalPage) {
		super();
		this.list = list;
		this.totalCount = totalCount;
		this.current = current;
		this.size = size;
		this.totalPage = totalPage;
	}


	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	public int getTotalPage() {
		int totalPage = (int) (getTotalCount() / getSize()); 
		return (totalCount % size == 0 ? totalPage : totalPage + 1);
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
}
