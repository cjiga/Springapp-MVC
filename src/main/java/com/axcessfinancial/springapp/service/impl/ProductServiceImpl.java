package com.axcessfinancial.springapp.service.impl;

import java.util.List;

import com.axcessfinancial.springapp.domain.Product;
import com.axcessfinancial.springapp.service.ProductService;

public class ProductServiceImpl implements ProductService {

	private List<Product> products;

	public List<Product> getProducts() {
		return products; 
	}
	
	public void increasePrice(int percentage) {
		if (products != null) {
            for (Product product : products) {
                double newPrice = product.getPrice().doubleValue() * 
                                    (100 + percentage)/100;
                product.setPrice(newPrice);
            }
        }  
	}

	public void setProducts(List<Product> products) {
		this.products = products;       
    }
}
