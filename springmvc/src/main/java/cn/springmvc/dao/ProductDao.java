package cn.springmvc.dao;

import java.util.List;

import cn.springmvc.model.Product;

public interface ProductDao {

	public List<Product> getProductList();

	public void saveProduct(Product prod);

}
