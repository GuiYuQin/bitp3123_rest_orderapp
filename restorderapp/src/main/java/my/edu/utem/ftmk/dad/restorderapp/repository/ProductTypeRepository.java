package my.edu.utem.ftmk.dad.restorderapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.restorderapp.model.ProductType;

/*
 * This class encapsulate the logic required to access data sources
 * extend Jpa Repository for managing the data of table ProductType
 * Jpa Repository contains the APIs for basic CRUD operations
 */
@Repository
public interface ProductTypeRepository 
	extends JpaRepository<ProductType, Long>{

}
