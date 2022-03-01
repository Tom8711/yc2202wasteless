
package nl.yc2202.Wasteless.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.yc2202.Wasteless.domein.Item;
import nl.yc2202.Wasteless.domein.User;



@Service
public class ItemService {
	@Autowired
	ItemRepository ir;
	
	UserService us;
	
	
	public Iterable<Item> getAllItems() {
		 return ir.findAll();
	}
	
	public void CreateItem(Item item, long userId) {
		ir.save(item);
		Optional<User> optinalEntity =  us.FindUserById(userId);
		User userEntity = optinalEntity.get();
		List<Item> excistingItems = userEntity.getItems();
		excistingItems.add(item);
		userEntity.setItems(excistingItems);
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

