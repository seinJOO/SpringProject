package com.zerock.util;

public class Criteria {
	
	private int nowPage;
	private int count;
	
	public Criteria() {
		this.nowPage = 1;
		this.count = 5;
	}

	public Criteria(int nowPage, int count) {
		super();
		this.nowPage = nowPage;
		this.count = count;
	}
	
	public int getPageStart() {
		return (nowPage - 1) * count;
	}

	public int getPageNum() {
		return nowPage;
	}

	public void setPageNum(int pageNum) {
		this.nowPage = pageNum;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
