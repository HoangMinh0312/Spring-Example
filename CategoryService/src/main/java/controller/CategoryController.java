package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import model.Category;
import service.ICategoryService;;

@RestController
public class CategoryController {
	@Autowired
	private ICategoryService categoryService;

	@RequestMapping("/categories")
	public List<Category> products() {
		return categoryService.getCategories();
	}
}
