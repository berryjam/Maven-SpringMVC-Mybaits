package cn.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.ProductDAO;
import cn.springmvc.model.Product;
import cn.springmvc.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	public List<Product> getProductList() {
		return productDAO.getProductList();
	}

	public void saveProduct(Product prod) {
		productDAO.saveProduct(prod);
	}

}
