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
 * */
@RestController
@RequestMapping("/api/ordertypes")
public class OrderTypeRESTController{
	
	@Autowired
	private OrderTypeRepository orderTypeRepository;
	
	/*
	 * Comment: 
	 * Retrieve all records from table OrderType
	 * using findAll method from interface OrderTypeRepository
	 * and hold by a list.
	 */
	@GetMapping
	public List<OrderType> getOrderTypes(){
		return orderTypeRepository.findAll();
	}
	
	/*
	 * This method retrieves a record from table OrderType 
	 * according to a web parameter's value.
	 */
	@GetMapping ("{orderTypeId}")
	public OrderType getOrderType(@PathVariable long orderTypeId) {
		
		OrderType orderType = orderTypeRepository.findById(orderTypeId).get();
		
		return orderType;
	}
	
	/*
	 * This method store new records to table OrderType
	 */
	@PostMapping()
	public OrderType insertOrderType(@RequestBody OrderType orderType) {
		return orderTypeRepository.save(orderType);
	}
	
	/*
	 * This method update records to table OrderType
	 */
	@PutMapping()
	public OrderType updateOrderType(@RequestBody OrderType orderType) {
		return orderTypeRepository.save(orderType);
	}
	
	/*
	 * This method delete records from table OrderType
	 */
	@DeleteMapping("{orderTypeId}")
	public ResponseEntity<HttpStatus> deleteOrderType(@PathVariable long orderTypeId){
		orderTypeRepository.deleteById(orderTypeId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
