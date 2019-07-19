package controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Category;
import model.Product;
import service.IProductService;

@RestController
@Component
public class ProductController {
	@Autowired
	private IProductService productService;

	@RequestMapping("/products")
	@PreAuthorize("#oauth2.hasScope('read')")
	public List<Product> products() {
		return productService.getProducts();
	}

	@RequestMapping("/categories")
	public List<Category> categories() throws JsonParseException, JsonMappingException, IOException {
		RestTemplate restTemplate = new RestTemplate();
		String categoryResourceUrl = "http://localhost:9999/categoryApi/categories";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer " + getToken());
		HttpEntity entity = new HttpEntity(headers);

		ResponseEntity<String> response = restTemplate.exchange(categoryResourceUrl, HttpMethod.GET, entity,
				String.class);
		ObjectMapper mapper = new ObjectMapper();

        List<Category> categories = mapper.readValue(response.getBody().toString(), new TypeReference<List<Category>>() {});

		return categories;
	}

	public static String getToken() {
		String token = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			token = ((OAuth2AuthenticationDetails) authentication.getDetails()).getTokenValue();
		}
		return token;
	}

}
