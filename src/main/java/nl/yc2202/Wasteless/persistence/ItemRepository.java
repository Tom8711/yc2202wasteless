package nl.yc2202.Wasteless.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.yc2202.Wasteless.domein.Item;

@Component
public interface ItemRepository extends CrudRepository<Item, Long> {
	
	
	
	List <Item> findByOfferedTrue();
	List <Item> findAllByOrderByExpirationDate();

}