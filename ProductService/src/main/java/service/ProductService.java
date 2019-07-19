package service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import model.Product;

@Service
public class ProductService implements IProductService {
	private static List<Product> products = new ArrayList<Product>();
	static {
		products.add(new Product(UUID.randomUUID(), "product 1"));
		products.add(new Product(UUID.randomUUID(), "product 2"));
		products.add(new Product(UUID.randomUUID(), "product 3"));
		products.add(new Product(UUID.randomUUID(), "product 4"));
		products.add(new Product(UUID.randomUUID(), "product 5"));
		products.add(new Product(UUID.randomUUID(), "product 6"));
	}

	@Override
	public List<Product> getProducts() {
		return products;
	}
}
