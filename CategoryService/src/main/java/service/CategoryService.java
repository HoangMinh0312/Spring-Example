package service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import model.Category;

@Service
public class CategoryService implements ICategoryService {
	private static List<Category> categories = new ArrayList<Category>();
	static {
		categories.add(new Category(UUID.randomUUID(), "category 1"));
		categories.add(new Category(UUID.randomUUID(), "category 2"));
		categories.add(new Category(UUID.randomUUID(), "category 3"));
		categories.add(new Category(UUID.randomUUID(), "category 4"));
		categories.add(new Category(UUID.randomUUID(), "category 5"));
		categories.add(new Category(UUID.randomUUID(), "category 6"));
	}

	@Override
	public List<Category> getCategories() {
		return categories;
	}
}