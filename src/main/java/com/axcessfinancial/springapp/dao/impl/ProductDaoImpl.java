package com.axcessfinancial.springapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.axcessfinancial.springapp.dao.ProductDao;
import com.axcessfinancial.springapp.domain.Product;

@Repository(value = "productDao")
public class ProductDaoImpl implements ProductDao {

	private EntityManager em = null;

	/* Sets the entity manager */
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		return em.createQuery("select p from Product p order by p.id")
				.getResultList();
	}

	@Transactional(readOnly = false)
	public void saveProduct(Product prod) {
		// TODO Auto-generated method stub
		em.merge(prod);
	}

}
