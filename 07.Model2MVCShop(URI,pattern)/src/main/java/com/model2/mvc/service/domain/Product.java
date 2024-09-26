package com.model2.mvc.service.domain;

import java.sql.Date;

public class Product {

	private String fileName; //String 타입의 상품 이미지 파일 이름
	private String manuDate; //String 타입의 상품 제조 일자
	private int price; //int 타입의 상품 가격
	private String prodDetail; //String 타입의 상품 상세 정보
	private String prodName; //String 타입의 상품명
	private int prodNo; //int 타입의 상품번호
	private Date regDate; //java.sql.Date 타입의 상품 등록 일자
	private String proTranCode;
	
	public Product() {
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getManuDate() {
		return manuDate;
	}

	public void setManuDate(String manuDate) {
		this.manuDate = manuDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProdDetail() {
		return prodDetail;
	}

	public void setProdDetail(String prodDetail) {
		this.prodDetail = prodDetail;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getProdNo() {
		return prodNo;
	}

	public void setProdNo(int string) {
		this.prodNo = string;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getProTranCode() {
		return proTranCode;
	}

	public void setProTranCode(String proTranCode) {
		this.proTranCode = proTranCode;
	}

	@Override
	public String toString() {
		return "ProductVO : [fileName]" + fileName
				+ "[manuDate]" + manuDate+ "[price]" + price + "[prodDetail]" + prodDetail
				+ "[prodName]" + prodName + "[prodNo]" + prodNo;
	}

	
}
