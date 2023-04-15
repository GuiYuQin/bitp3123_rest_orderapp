package my.edu.utem.ftmk.dad.restorderapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import my.edu.utem.ftmk.dad.restorderapp.model.ProductType;
import my.edu.utem.ftmk.dad.restorderapp.repository.ProductTypeRepository;

/*
 * Comment:
 * @RequestMapping use with class definition to create a URI
 * now /api/producttypes is the URI for this controller
 * this class handles requests
 * */
@RestController
@RequestMapping("/api/producttypes")
public class ProductTypeRESTController {
	
	@Autowired
	private ProductTypeRepository productTypeRepository;
	
	/*
	 * Comment: 
	 * Retrieve all records from table producttype
	 * using findAll() method from interface ProductTypeRepository
	 * that extends the JpaRepository
	 * and the result is present in list
	 */
	@GetMapping
	public List<ProductType> getProductType() {
		return productTypeRepository.findAll();
	}
	
	/*
	 * This method retrieves a record from table producttype 
	 * according to a web parameter's value which is 
	 * productTypeId using findById() method and 
	 * get() method to retrieve result
	 */
	@GetMapping ("{productTypeId}")
	public ProductType getProductType(@PathVariable long productTypeId) {
		return productTypeRepository.findById(productTypeId).get();
	}
	
	/*
	 * This method save new record using the save() methods
	 * variable productType will contains the value for 
	 * attributes of ProductType. The productTypeId will be auto-generated
	 * because the entity is not exist
	 */
	@PostMapping()
	public ProductType insertProductType(@RequestBody ProductType productType) {
		return productTypeRepository.save(productType);
	}
	
	/*
	 * This method update records using the save() methods
	 * this methods will merge the record if it is existed
	 * all attribute are updated according to merging
	 */
	@PutMapping()
	public ProductType updateProductType(@RequestBody ProductType productType) {
		return productTypeRepository.save(productType);
	}
	
	/*
	 * This method delete records from table producttype
	 * based on the productTypeId from the web parameter's
	 * it will return status 200 if record successfully deleted
	 */
	@DeleteMapping("{productTypeId}")
	public ResponseEntity<HttpStatus> deleteOrderType(@PathVariable long productTypeId){
		productTypeRepository.deleteById(productTypeId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
