package com.zerock.util;

public class PageVO {
	
	private int startPage;
	private int endPage;
	private boolean prev, next;
	private int pageNum;
	private int total;
	private Criteria cri;
	
	public PageVO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		this.pageNum = cri.getPageNum();
		
		this.startPage = endPage - 5 + 1;
		this.endPage = (int)Math.ceil(cri.getPageNum() / (double) 5) * 5;
		int realEnd = (int)Math.ceil(total / (double)cri.getCount());
		if (this.endPage > realEnd) this.endPage = realEnd;
		
		this.prev = this.startPage > 1;
		this.next = realEnd > this.endPage;	
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	
	
	
	
}
