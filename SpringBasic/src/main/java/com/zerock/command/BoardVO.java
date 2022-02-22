package com.zerock.command;

public class BoardVO {
	
	private int num;
	private String name;
	private String title;
	private String content;
	
	public BoardVO() {} // 기본생성자 - 의미는 없지만 오류 방지를 위해 만듬
	
	
	
	public BoardVO(String name, String title, String content) {
		super();
		this.name = name;
		this.title = title;
		this.content = content;
	}



	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	

}
