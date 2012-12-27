package com.axcessfinancial.springapp.web;

import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.axcessfinancial.springapp.service.impl.ProductServiceImpl;

public class InventoryControllerTests {

	@Test
	public void testHandleRequestView() throws Exception{		
        InventoryController controller = new InventoryController();
        controller.setProductService(new ProductServiceImpl());
        ModelAndView modelAndView = controller.handleRequest(null, null);	
        Assert.assertEquals("hello", modelAndView.getViewName());
        Assert.assertNotNull(modelAndView.getModel());
        Map modelMap = (Map) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        //String nowValue = (String) modelAndView.getModel().get("now");
        Assert.assertNotNull(nowValue);
        
    }
}
