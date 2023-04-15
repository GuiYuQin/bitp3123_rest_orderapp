package my.edu.utem.ftmk.dad.restorderapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import my.edu.utem.ftmk.dad.restorderapp.model.OrderType;
import my.edu.utem.ftmk.dad.restorderapp.repository.OrderTypeRepository;

/*
 * Comment:
 * @RequestMapping use with class definition to create a URI
 * now /api/ordertypes is the URI for this controller
 * this class handles requests
 * */
@RestController
@RequestMapping("/api/ordertypes")
public class OrderTypeRESTController{
	
	@Autowired
	private OrderTypeRepository orderTypeRepository;
	
	/*
	 * Comment: 
	 * Retrieve all records from table OrderType
	 * using findAll() method from interface OrderTypeRepository
	 * and hold by a list
	 */
	@GetMapping
	public List<OrderType> getOrderTypes(){
		return orderTypeRepository.findAll();
	}
	
	/*
	 * This method retrieves a record from table OrderType 
	 * according to a web parameter's value which is 
	 * orderTypeId using findById() method
	 */
	@GetMapping ("{orderTypeId}")
	public OrderType getOrderType(@PathVariable long orderTypeId) {
		
		OrderType orderType = orderTypeRepository.findById(orderTypeId).get();
		
		return orderType;
	}
	
	/*
	 * This method save new record using the save() methods
	 * variable orderType will contains the value for 
	 * attributes of OrderType. The orderTypeId will be auto-generated
	 * if the entity is not exist
	 */
	@PostMapping()
	public OrderType insertOrderType(@RequestBody OrderType orderType) {
		return orderTypeRepository.save(orderType);
	}
	
	/*
	 * This method update records using the save() methods
	 * this methods will merge the record if it is existed
	 * all attribute are updated according to merging
	 */
	@PutMapping()
	public OrderType updateOrderType(@RequestBody OrderType orderType) {
		return orderTypeRepository.save(orderType);
	}
	
	/*
	 * This method delete records from table OrderType
	 * based on the orderTypeId from the web parameter's
	 * it will return status 200 if record successfully deleted
	 */
	@DeleteMapping("{orderTypeId}")
	public ResponseEntity<HttpStatus> deleteOrderType(@PathVariable long orderTypeId){
		orderTypeRepository.deleteById(orderTypeId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
