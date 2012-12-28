package com.axcessfinancial.springapp.dao;

import java.util.List;

import com.axcessfinancial.springapp.domain.Product;

public interface ProductDao {

	public List<Product> getProductList();

	public void saveProduct(Product prod);

}
