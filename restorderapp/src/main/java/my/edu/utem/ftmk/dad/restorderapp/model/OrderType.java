package my.edu.utem.ftmk.dad.restorderapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * refer to table ordertype which have orderTypeId as PK
 * it contains setter and getter for the attribute in ordertype
 */
@Entity
@Table(name = "ordertype") //name of table in database
public class OrderType {
	
	@Id // PK 
	@GeneratedValue(strategy=GenerationType.IDENTITY)	//auto increment
	@Column (name="orderTypeId") //name of column in database
	private int orderTypeId;
	
	@Column (name="code")
	private String code;
	
	@Column (name="name")
	private String name;
	
	public int getOrderTypeId() {
		return orderTypeId;
	}
	
	public void setOrderTypeId(int orderTypeId) {
		this.orderTypeId = orderTypeId;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
