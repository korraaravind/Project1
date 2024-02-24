package dao;

import java.util.List;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.stereotype.Repository;

import Models.Product;

@Repository
	public interface ProductDAO extends JpaRepository<Producer, Long> {

	List<Product> findAll();
	    // Add custom query methods if needed

	Product findById(Long productId);

	Product save(Product product);

	void deleteById(Long productId);


}
