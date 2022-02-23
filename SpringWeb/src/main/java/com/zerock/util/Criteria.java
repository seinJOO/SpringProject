package com.zerock.util;

public class Criteria {
	
	private int pageNum;
	private int count;
	
	public Criteria() {
		this.pageNum = 1;
		this.count = 5;
	}

	public Criteria(int pageNum, int count) {
		super();
		this.pageNum = pageNum;
		this.count = count;
	}
	
	public int getPageStart() {
		return (pageNum - 1) * count;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
