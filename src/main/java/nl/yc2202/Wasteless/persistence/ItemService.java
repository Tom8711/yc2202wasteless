
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
	
	@Autowired
	UserRepository us;
	
	public Iterable<Item> getAllClaimedItemsByUserId(long userId) {
		Optional<User> optionalUser =  us.findById(userId);
		
		if(optionalUser.isPresent()) {
			User userEntity = optionalUser.get();
			return ir.findByClaimNotNullAndUser(userEntity);
		}
		return ir.findByClaimNotNullAndUser(new User());
		
	}
	
	public Iterable<Item> getAllItemsById(long userId) {
		Optional<User> optionalUser =  us.findById(userId);
		
		if(optionalUser.isPresent()) {
			User userEntity = optionalUser.get();
			return ir.findAllByUser(userEntity);
		}
		return ir.findAllByUser(new User());
	}
	
	public Iterable<Item> getAllItems() {
		 return ir.findAll();
	}
	
	public void CreateItem(Item item, long userId) {
		
		Optional<User> optionalUser =  us.findById(userId);
		
		if(optionalUser.isPresent()) {
			User userEntity = optionalUser.get();
			item.setUser(userEntity);
			ir.save(item);
		}
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
	
	public Optional<Item> FindById(long itemid) {
		return ir.findById(itemid);
	}
	
		
}	

