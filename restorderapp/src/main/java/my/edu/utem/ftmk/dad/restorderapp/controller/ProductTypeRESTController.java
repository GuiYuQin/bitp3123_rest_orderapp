package my.edu.utem.ftmk.dad.restorderapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import my.edu.utem.ftmk.dad.restorderapp.model.ProductType;
import my.edu.utem.ftmk.dad.restorderapp.repository.ProductTypeRepository;

/*
 * 
 */
@RestController
@RequestMapping("/api/producttypes")
public class ProductTypeRESTController {
	
	@Autowired
	private ProductTypeRepository productTypeRepository;
	
	@GetMapping
	public List<ProductType> getProductType() {
		return productTypeRepository.findAll();
	}
	
	@GetMapping ("{productTypeId}")
	public ProductType getProductType(@PathVariable long productTypeId) {
		return productTypeRepository.findById(productTypeId).get();
	}
	
	@PostMapping()
	public ProductType insertProductType(@RequestBody ProductType productType) {
		return productTypeRepository.save(productType);
	}
	
	@PutMapping()
	public ProductType updateProductType(@RequestBody ProductType productType) {
		return productTypeRepository.save(productType);
	}
	
	@DeleteMapping("{productTypeId}")
	public ResponseEntity<HttpStatus> deleteOrderType(@PathVariable long productTypeId){
		productTypeRepository.deleteById(productTypeId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
