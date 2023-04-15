package my.edu.utem.ftmk.dad.restorderapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import my.edu.utem.ftmk.dad.restorderapp.model.Product;

/*
 * This class encapsulate the logic required to access data sources
 * extend Jpa Repository for managing the data of table Product
 * Jpa Repository contains the APIs for basic CRUD operations
 */
public interface ProductRepository 
	extends JpaRepository<Product, Long> {

}
