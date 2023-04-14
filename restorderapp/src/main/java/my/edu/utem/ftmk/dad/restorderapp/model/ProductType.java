package my.edu.utem.ftmk.dad.restorderapp.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "producttype")
public class ProductType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="productTypeId")
	protected int productTypeId;

	@Column (name="name")
	private String name;
	
	@OneToMany(mappedBy = "productType")
	private List<Product> product;
	
	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
