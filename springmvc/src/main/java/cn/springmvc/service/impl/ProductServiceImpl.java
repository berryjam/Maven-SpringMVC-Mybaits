package cn.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.ProductDao;
import cn.springmvc.model.Product;
import cn.springmvc.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	public List<Product> getProductList() {
		return productDao.getProductList();
	}

	public void saveProduct(Product prod) {
		productDao.saveProduct(prod);
	}

}
