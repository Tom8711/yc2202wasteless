
package nl.yc2202.Wasteless.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.yc2202.Wasteless.domein.Item;



@Service
public class ItemService {
	@Autowired
	ItemRepository ir;

	
	
	public Iterable<Item> getAllItems() {
		 return ir.findAll();
	}
	
	public void CreateItem(Item item) {
		ir.save(item);
	}
	
	public void DeleteItem(long id) {
        ir.deleteById(id);
    }
	
	public List<Item> getAllOfferedItems() {
		 
		return ir.findByOfferedTrue();
	
	}
	
	public List<Item> getAllItemsSortedByDate(){
		return ir.findAllByOrderByExpirationDate();
	}
	
	
		
}	

