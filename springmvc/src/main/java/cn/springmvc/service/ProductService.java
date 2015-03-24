package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.Product;

public interface ProductService {

	public List<Product> getProductList();

	public void saveProduct(Product prod);
}
