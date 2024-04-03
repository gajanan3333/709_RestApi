package com.jbk.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jbk.dao.ProductDao;
import com.jbk.exception.ResourceNotExistException;
import com.jbk.exception.ResourceNotFoundException;
import com.jbk.exception.SomethingWentWrongException;
import com.jbk.model.Product;

@Component
public class ProductDaoimpl implements ProductDao {

	List<Product> list = new ArrayList<>();	
	public ProductDaoimpl() {
		list.add(new Product(1,"xyz",10,100,"2022-01-12","2025-06-06"));
		list.add(new Product(2,"abc",10,100,"2022-01-12","2025-06-07"));
		list.add(new Product(3,"pqr",10,100,"2022-01-12","2025-08-08"));
	}

	@Override
	public int addProduct(Product product) {
		//int status=0;
		
		try {
			
			for (Product listProduct : list) 
			{
				if(listProduct.getProductName().equalsIgnoreCase(product.getProductName()))
				{
					return 2;
					//status=2;
					//break;
				}
			   }
			list.add(product);
			// status=1;
			return 1;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			//return 3;
			//status=3;
			 throw new SomethingWentWrongException("Something Went Wrong While Retrive Product");
			
		}
		
		
		
		
	}

	@Override
	public Product getProductById(long productid) {
		try {
			for (Product product : list) {
				if(product.getProductid()==productid) {
					return product;
				}
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new SomethingWentWrongException("Something Went Wrong While Retrive Product");
		}
		throw new ResourceNotFoundException("Product Not Found with Id"+productid);
	}

	@Override
	public List<Product> getAllProduct() {
		
		return list;
	}

	@Override
	public int deleteProduct(long productid) {
		try {
			boolean productfound = list.removeIf(p->p.getProductid()==productid);
			if(!productfound) 
			{
				throw new ResourceNotExistException("Product not found with ID: " + productid);
				
			}
			else{
				return 1;
		   }
		}catch(ResourceNotExistException e)
		{
			throw new ResourceNotExistException("Product not found with ID :-" + productid);
		} catch (Exception e) 
		{
			e.printStackTrace();
			throw new ResourceNotExistException("Something went wrong with product id in the list :-" + productid);
		}
		
		
		
/*		boolean productFound = false;

	    for (Iterator<Product> iterator = list.iterator(); iterator.hasNext();) {
	        Product product = iterator.next();

	        if (product.getProductid() == productid) {
	            iterator.remove(); // Safely remove the current element
	            productFound = true;
	            break; // Exit the loop once the product is found and deleted
	        }
	    }

	    if (productFound) {
	        return 1; // Indicate successful deletion
	    } else {
	        throw new ResourceNotExistException("Product not found with ID: " + productid);
	    }
*/	
/*	try {
			for (Product product : list) {
				if(product.getProductid()==productid) {
					list.remove(product);
					return 1;
				}else {
					throw new ResourceNotExistException("Product is not found with id: " + productid);
				}
			}
		}catch(ResourceNotExistException e)
		{
			throw new ResourceNotExistException("Product is not found with id: " + productid);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new ResourceNotExistException("Product not Exist To delete, List Is Empty");
		}
		 throw new ResourceNotExistException("Product not exist To Delete, List Is Empty");	 
		
		*/
		/* try {
		        Iterator<Product> iterator = list.iterator();

		        while (iterator.hasNext()) {
		            Product product = iterator.next();
		            if (product.getProductid() == productid) {
		                iterator.remove(); 
		                return 1; 
		            }else {
		            	 throw new ResourceNotExistException("Product is not found with id: " + productid);
		             }
		           }
               }
		       catch(ResourceNotExistException e){
				throw new ResourceNotExistException("Product not Exist To delete to this List ");
			   }catch (Exception e) {
		         e.printStackTrace(); 
		        throw new ResourceNotExistException("Product not Exist To delete, List Is Empty");
		    }
		 throw new ResourceNotExistException("Product not Exist To delete, List Is Empty");	 
*/
	}

	@Override
	public int updateProduct(Product product) {
		try {
			for (Product listproduct : list) {
				if(listproduct.getProductid()==product.getProductid()) {
				   list.set(list.indexOf(listproduct), product);
					return 1;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new SomethingWentWrongException("Something Went to Wrong");
		}
		throw new ResourceNotExistException("Product not exist to update");
	}

	@Override
	public List<Product> getProductByCostMoreThan500(double productPrice) {
		
		  List<Product> result = new ArrayList<Product>();
		  try {
			    double minPrice = 500;
			    for (Product product : list) {
					if(product.getProductPrice()>=minPrice && product.getProductPrice()==productPrice) {
						result.add(product);
						return result;
					}
				}
			  
		} catch (Exception e) {
			    e.printStackTrace();
			    throw new SomethingWentWrongException("Some thing Went Wrong");
		}
		
		throw new ResourceNotExistException("Product not Found");
		
		
	}

	
}
