package my.edu.utem.ftmk.dad.restorderapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

import my.edu.utem.ftmk.dad.restorderapp.model.Product;
import my.edu.utem.ftmk.dad.restorderapp.repository.ProductRepository;

@RestController
@RequestMapping("/api/product")
public class ProductRESTController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public List<Product>getProduct(){
		return productRepository.findAll();
	}
	
	@GetMapping("{productId}")
	public Product getProduct(@PathVariable long productId) {
		return productRepository.findById(productId).get();
	}
	
	@PostMapping()
	public Product insertProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@PutMapping()
	public Product updateProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@DeleteMapping("{productId}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable long productId){
		productRepository.deleteById(productId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
