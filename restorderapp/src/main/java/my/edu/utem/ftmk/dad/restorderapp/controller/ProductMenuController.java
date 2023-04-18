package my.edu.utem.ftmk.dad.restorderapp.controller;

import java.util.*;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import my.edu.utem.ftmk.dad.restorderapp.model.Product;

/*
 * This class manage the request from front end and
 * consume REST web service to manage the CRUD operation
 */
@Controller
public class ProductMenuController {
	private String defaultURI = "http://localhost:8080/orderapp/api/product";
	
	/*
	 * This method consume a GET web service and 
	 * display a list of record
	 */
	@GetMapping("/product/list")
	public String getProduct(Model model) {
		
		//Get a list product from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Product[]> response = restTemplate.getForEntity(defaultURI, Product[].class);
		
		//Parse JSON data to array of object
		Product products[] = response.getBody();
		
		//Parse an array to a list object
		List<Product> productList = Arrays.asList(products);
		
		//Attach list to model as attribute
		model.addAttribute("products", productList);
		
		return "products";
		
	}
	
	/*this method will update or add an product
	 * @param product
	 * @return
	 */
	@RequestMapping("/product/save")
	public String updateProduct(@ModelAttribute Product product) {
		//Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		//create request body
		HttpEntity<Product> request = new HttpEntity<Product>(product);
		
		String productResponse = "";

		if(product.getProductId() > 0) {
			//This block update an new product and
			//send request as PUT
			restTemplate.put(defaultURI, request, Product.class);
		}
		else {
			//this block add a new product
			//send request as POST
			productResponse = restTemplate.postForObject(defaultURI, request, String.class);
		}
		
		System.out.println(productResponse);
		
		//Redirect request to display a list of product
		return "redirect:/product/list";
	}
	
	/*
	 * This method gets an product
	 * 
	 * @param productId
	 * @param model
	 * @return
	 */
	@GetMapping("/product/{productId}")
	public String getProduct(@PathVariable Integer productId, Model model) {
		String pageTitle = "New Product";
		Product product = new Product();

		//This block get an product to be updated
		if(productId > 0) {
			//generate new URI and append productId to it
			String uri = defaultURI + "/" + productId;
			
			//Get an product from the web service
			RestTemplate restTemplate = new RestTemplate();
			product = restTemplate.getForObject(uri, Product.class);
			
			//Give a new title to the page
			pageTitle = "Edit Product";
		}
		
		//Attach value to pass to front end
		model.addAttribute("product", product);
		model.addAttribute("pageTitle", pageTitle);
		
		return "productinfo";
	}
	
	/*
	 * this method deletes an product
	 * 
	 * @param productId
	 * @return
	 */
	@RequestMapping("/product/delete/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		//Generate new URI, similar to the mapping in ProductRESTController
		String uri = defaultURI + "/{productId}";
		
		//Send a DELETE request and attach the value of productId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("productId", Integer.toString(productId)));
		
		return "redirect:/product/list";
	}
}
