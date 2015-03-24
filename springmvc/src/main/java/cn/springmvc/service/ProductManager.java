package cn.springmvc.service;

import java.io.Serializable;
import java.util.List;

import cn.springmvc.model.Product;

public interface ProductManager extends Serializable {
	public void increasePrice(int percentage);

	public List<Product> getProducts();
}
