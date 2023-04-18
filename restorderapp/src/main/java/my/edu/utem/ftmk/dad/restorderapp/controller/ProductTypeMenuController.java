package my.edu.utem.ftmk.dad.restorderapp.controller;

import java.util.*;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import my.edu.utem.ftmk.dad.restorderapp.model.ProductType;

/*
 * This class manage the request from front end and
 * consume REST web service to manage the CRUD operation
 */
@Controller
public class ProductTypeMenuController {

	private String defaultURI = "http://localhost:8080/orderapp/api/producttypes";
	
	/*
	 * This method consume a GET web service and 
	 * display a list of record
	 */
	@GetMapping("/producttype/list")
	public String getProductType(Model model) {
		
		//Get a list product types from the web service
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ProductType[]> response = restTemplate.getForEntity(defaultURI, ProductType[].class);
		
		//Parse JSON data to array of object
		ProductType productTypes[] = response.getBody();
		
		//Parse an array to a list object
		List<ProductType> productTypeList = Arrays.asList(productTypes);
		
		//Attach list to model as attribute
		model.addAttribute("productTypes", productTypeList);
		
		return "producttypes";
		
	}
	
	/*this method will update or add an product type
	 * @param productType
	 * @return
	 */
	@RequestMapping("/producttype/save")
	public String updateProductType(@ModelAttribute ProductType productType) {
		//Create a new RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		
		//create request body
		HttpEntity<ProductType> request = new HttpEntity<ProductType>(productType);
		
		String productTypeResponse = "";

		if(productType.getProductTypeId() > 0) {
			//This block update an new product type and
			//send request as PUT
			restTemplate.put(defaultURI, request, ProductType.class);
		}
		else {
			//this block add a new product type
			//send request as POST
			productTypeResponse = restTemplate.postForObject(defaultURI, request, String.class);
		}
		
		System.out.println(productTypeResponse);
		
		//Redirect request to display a list of product type
		return "redirect:/producttype/list";
	}
	
	/*
	 * This method gets an product type
	 * 
	 * @param productTypeId
	 * @param model
	 * @return
	 */
	@GetMapping("/producttype/{productTypeId}")
	public String getProductType(@PathVariable Integer productTypeId, Model model) {
		String pageTitle = "New Product Type";
		ProductType productType = new ProductType();

		//This block get an product type to be updated
		if(productTypeId > 0) {
			//generate new URI and append productTypeId to it
			String uri = defaultURI + "/" + productTypeId;
			
			//Get an product type from the web service
			RestTemplate restTemplate = new RestTemplate();
			productType = restTemplate.getForObject(uri, ProductType.class);
			
			//Give a new title to the page
			pageTitle = "Edit Product Type";
		}
		
		//Attach value to pass to front end
		model.addAttribute("productType", productType);
		model.addAttribute("pageTitle", pageTitle);
		
		return "producttypeinfo";
	}
	
	/*
	 * this method deletes an product type
	 * 
	 * @param productTypeId
	 * @return
	 */
	@RequestMapping("/producttype/delete/{productTypeId}")
	public String deleteProductType(@PathVariable int productTypeId) {
		//Generate new URI, similar to the mapping in ProductTypeRESTController
		String uri = defaultURI + "/{productTypeId}";
		
		//Send a DELETE request and attach the value of productTypeId into URI
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(uri, Map.of("productTypeId", Integer.toString(productTypeId)));
		
		return "redirect:/producttype/list";
	}
}
