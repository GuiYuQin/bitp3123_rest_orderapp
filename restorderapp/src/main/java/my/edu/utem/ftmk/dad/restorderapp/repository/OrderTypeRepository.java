/**
 * 
 */
package my.edu.utem.ftmk.dad.restorderapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.restorderapp.model.OrderType;

/**
 * @author yuqin
 *
 */

/*
 * This class encapsulate the logic required to access data sources
 * extend Jpa Repository for managing the data of table OrderType
 * Jpa Repository contains the APIs for basic CRUD operations
 * JpaRepository<T, ID> : where T=Entity/Model, ID=wrapper class of entity @Id 
 */

@Repository
public interface OrderTypeRepository 
	extends JpaRepository<OrderType, Long>{
	
}
