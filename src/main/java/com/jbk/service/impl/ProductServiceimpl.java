package com.jbk.service.impl;



import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jbk.dao.ProductDao;
import com.jbk.model.Product;
import com.jbk.service.ProductService;

@Component
public class ProductServiceimpl implements ProductService {
	@Autowired
    ProductDao dao;

	@Override
	public int addProduct(Product product) {
		
		String productId = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		product.setProductid(Long.parseLong(productId));
		System.out.println(productId);
		return dao.addProduct(product);
	}

	@Override
	public Product getProductById(long productid) {
		
		return dao.getProductById(productid);
	}

	@Override
	public List<Product> getAllProduct() {
	
		return dao.getAllProduct();
	}

	@Override
	public int deleteProduct(long productid) {
	
		return dao.deleteProduct(productid);
	}

	@Override
	public int updateProduct(Product product) {
		
		return dao.updateProduct(product);
	}

	@Override
	public List<Product> getProductByCostMoreThan500( double productPrice) {
		
		return dao.getProductByCostMoreThan500(productPrice);
	}

	

	

}
