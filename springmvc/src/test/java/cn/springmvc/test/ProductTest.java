package cn.springmvc.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.springmvc.model.Product;
import cn.springmvc.service.ProductService;

public class ProductTest {

	private ProductService productService;

	@Before
	public void before() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:conf/spring.xml",
						"classpath:conf/spring-mybatis.xml" });
		productService = (ProductService) context.getBean("productServiceImpl");
	}

	public void addProduct() {
		Product prod = new Product();
		prod.setId(909);
		prod.setDescription("Laptop");
		prod.setPrice(100.2);
		productService.saveProduct(prod);
	}

	@Test
	public void getProductList() {
		List<Product> list = productService.getProductList();
		for (Product prod : list)
			System.out.println(prod.toString());
	}
}
