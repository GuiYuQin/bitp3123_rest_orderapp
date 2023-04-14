package my.edu.utem.ftmk.dad.restorderapp.model;

import jakarta.persistence.*;

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
	
	public int getProductType() {
		return productType.getProductTypeId();
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
}
