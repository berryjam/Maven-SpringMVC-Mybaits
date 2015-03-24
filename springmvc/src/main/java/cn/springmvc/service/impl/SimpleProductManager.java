package cn.springmvc.service.impl;

import java.util.List;

import cn.springmvc.model.Product;
import cn.springmvc.service.ProductManager;

public class SimpleProductManager implements ProductManager {

	private List<Product> products;

	public void increasePrice(int percentage) {
		if (products != null) {
			for (Product product : products) {
				double newPrice = product.getPrice().doubleValue()
						* (100 + percentage) / 100;
				product.setPrice(newPrice);
			}
		}
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
