package my.edu.utem.ftmk.dad.restorderapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/*
 * refer to table product which have productId as PK and productType as FK
 * it contains setter and getter for the attribute
 * relationship of producttype and product is defined which
 * each producttype can be assigned to zero, one or many product
 * the column to join is also defined with @JoinColumn annotation
 */
@Entity
@Table(name = "product")
public class Product{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="productId")
	private int productId;
	
	@Column (name="name")
	private String name;
	
	@Column (name="price")
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "productType", nullable = false)
	private ProductType productType;
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
}
