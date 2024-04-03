package com.jbk.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Product {

	private long productid;
	
	//@NotBlank(message ="Product Name should not be Null")
	@Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9]*$", message = "Invalied Product Name")
	private String productName;
	
	@Min(1)
	private int productQty;
	@Min(1)
	private double ProductPrice;
	@Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Invalid date format. Please use YYYY-MM-DD.")
	private String mfdDate;
	 @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Invalid date format. Please use YYYY-MM-DD.")
	private String expDate;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(long productid, String productName, int productQty, double productPrice, String mfdDate,
			String expDate) {
		super();
		this.productid = productid;
		this.productName = productName;
		this.productQty = productQty;
		ProductPrice = productPrice;
		this.mfdDate = mfdDate;
		this.expDate = expDate;
	}
	public long getProductid() {
		return productid;
	}
	public void setProductid(long productid) {
		this.productid = productid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductQty() {
		return productQty;
	}
	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}
	public double getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(double productPrice) {
		ProductPrice = productPrice;
	}
	public String getMfdDate() {
		return mfdDate;
	}
	public void setMfdDate(String mfdDate) {
		this.mfdDate = mfdDate;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productName=" + productName + ", productQty=" + productQty
				+ ", ProductPrice=" + ProductPrice + ", mfdDate=" + mfdDate + ", expDate=" + expDate + "]";
	}

	
	
	
	
}
