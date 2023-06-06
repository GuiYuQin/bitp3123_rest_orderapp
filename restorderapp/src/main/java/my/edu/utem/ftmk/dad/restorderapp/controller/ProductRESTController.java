package my.edu.utem.ftmk.dad.restorderapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.dad.restorderapp.model.Product;
import my.edu.utem.ftmk.dad.restorderapp.repository.ProductRepository;

/*
 * Comment:
 * @RequestMapping use with class definition to create a URI
 * now /api/product is the URI for this controller
 * this class handles requests
 * */
@RestController
@RequestMapping("/api/product")
public class ProductRESTController {
	
	@Autowired
	private ProductRepository productRepository;
	
	/*
	 * Comment: 
	 * Retrieve all records from table product
	 * using findAll() method from interface ProductRepository
	 * that extends the JpaRepository
	 * and the result is present in list
	 */
	@GetMapping
	public List<Product>getProduct(){
		return productRepository.findAll();
	}
	
	/*
	 * This method retrieves a record from table product
	 * according to a web parameter's value which is 
	 * productId using findById() method and 
	 * get() method to retrieve result
	 */
	@GetMapping("{productId}")
	public Product getProduct(@PathVariable long productId) {
		return productRepository.findById(productId).get();
	}
	
	/*
	 * This method save new record using the save() methods
	 * variable product will contains the value for 
	 * attributes of Product. The productId will be auto-generated
	 * because the entity is not exist
	 */
	@PostMapping()
	public Product insertProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	/*
	 * This method update records using the save() methods
	 * this methods will merge the record if it is existed
	 * all attribute are updated according to merging
	 */
	@PutMapping()
	public Product updateProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	/*
	 * This method delete records from table product
	 * based on the productId from the web parameter's
	 * it will return status 200 if record successfully deleted
	 */
	@DeleteMapping("{productId}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable long productId){
		productRepository.deleteById(productId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
