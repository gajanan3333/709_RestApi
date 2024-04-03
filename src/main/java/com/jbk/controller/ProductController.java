package com.jbk.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.exception.ResourceNotExistException;
import com.jbk.model.Product;
import com.jbk.service.ProductService;


@RestController
public class ProductController {
	
	@Autowired
	ProductService service ;
	
	
	@PostMapping("/add-product")
	public String addProduct(@RequestBody @Valid Product Product) {
	int status=	service.addProduct(Product);
		
	if(status==1) {
		return "Product added Sucessfully";
	}
	else 
	{
		return "Already Exist Product Name"+Product.getProductName();
	}
		
	}
	
	@GetMapping("/get-product-by-id/{id}") // {_} PlaceHolder
	public ResponseEntity<Product> getProductById(@PathVariable("id") long productid) {
		
		Product product = service.getProductById(productid);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
			
	}
	
	@GetMapping("/get-all-produts")
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> productlist = service.getAllProduct();
		if(!productlist.isEmpty())
		{
			return new ResponseEntity<List<Product>>(productlist,HttpStatus.OK);
		}else {
			throw new ResourceNotExistException("Product Not Exist,List is Empty");
		}
		
		}
	
	@DeleteMapping("/delete-product-by-id")
	 public ResponseEntity<String> deleteProductby(@RequestParam @Valid long productid){
		int status =service.deleteProduct(productid);
		
		 return new  ResponseEntity<String>("Deleted",HttpStatus.MOVED_PERMANENTLY);
		 
		}
	
	@PutMapping("/update-product")
	public ResponseEntity<String> updateProduct(@RequestBody @Valid Product product){
		service.updateProduct(product);
		return new  ResponseEntity<String>("Updated sucessfully",HttpStatus.OK);
		
		}
	// we do not use  @Valid in the particular requirement. whenever we get the body of the particular object that time we can use @valid
	@GetMapping("get-products-by-cost/{cost}")  
	 public ResponseEntity<List<Product>> getProductByCostMoreThan500(@RequestParam("cost")  double ProductPrice) {
		
		 List<Product> listofproduct = service.getProductByCostMoreThan500(ProductPrice);
		 
		 if(listofproduct.isEmpty()) {
			 return ResponseEntity.noContent().build();
		 }else {
			  return ResponseEntity.ok(listofproduct);
		 }
		
		
	}	
	
}
