package com.axcessfinancial.springapp.service;

import java.util.List;

import com.axcessfinancial.springapp.domain.Product;

public interface ProductService {
	public void increasePrice(int percentage);

	public List<Product> getProducts();
}
