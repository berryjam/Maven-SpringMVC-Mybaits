package cn.springmvc.test.controller;

import java.util.Map;

import junit.framework.TestCase;

import org.springframework.web.servlet.ModelAndView;

import cn.springmvc.controller.InventoryController;
import cn.springmvc.service.impl.SimpleProductManager;

public class InventoryControllerTests extends TestCase {

	public void testHandleRequestView() throws Exception {
		InventoryController controller = new InventoryController();
		controller.setProductManager(new SimpleProductManager());
		ModelAndView modelAndView = controller.handleRequest(null, null);
		assertEquals("hello", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
		Map modelMap = (Map) modelAndView.getModel().get("model");
		String nowValue = (String) modelMap.get("now");
		assertNotNull(nowValue);
	}
}
