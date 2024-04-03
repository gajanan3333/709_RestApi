package com.jbk.dao;

import java.util.List;

import com.jbk.model.Product;

public interface ProductDao {

	public int addProduct(Product product );
	public Product getProductById(long productid);
	public List<Product> getAllProduct();
	public int deleteProduct(long productid);
	public int updateProduct(Product product);
	public List<Product> getProductByCostMoreThan500(double productPrice);
	
	
}
