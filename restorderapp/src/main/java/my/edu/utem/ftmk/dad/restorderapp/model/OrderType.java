package my.edu.utem.ftmk.dad.restorderapp.model;

import jakarta.persistence.*;

//Retrieve and store value to OrderType table
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
