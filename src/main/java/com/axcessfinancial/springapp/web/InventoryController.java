package com.axcessfinancial.springapp.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.axcessfinancial.springapp.service.ProductService;


@Controller
public class InventoryController {
	
	protected final Log logger=LogFactory.getLog(getClass());
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/hello.htm")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String now = (new Date()).toString();
        logger.info("Returning hello view with " + now);
        
        Map<String,Object> myModel=new HashMap<String,Object>();
        myModel.put("now", now);
        myModel.put("products",this.productService.getProducts());

        return new ModelAndView("hello", "model", myModel);
        //return new ModelAndView("hello.jsp");
    }


	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
}
