
package nl.yc2202.Wasteless.persistence;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.yc2202.Wasteless.domein.Claim;
import nl.yc2202.Wasteless.domein.Item;
import nl.yc2202.Wasteless.domein.User;



@Service
public class ItemService {
	@Autowired
	ItemRepository ir;
	
	@Autowired
	UserRepository ur;
	
	@Autowired
	ClaimRepository cr;
	
	
	public Iterable<Item> getAllClaimedItemsByUserId(long userId) {
		Optional<User> optionalUser =  ur.findById(userId);
		
		if(optionalUser.isPresent()) {
			User userEntity = optionalUser.get();
			return ir.findByClaimNotNullAndUser(userEntity);
		}
		return ir.findByClaimNotNullAndUser(new User());
		
	}
	
	public Iterable<Item> getAllItemsByUserId(long userId) {
		Optional<User> optionalUser =  ur.findById(userId);
		
		if(optionalUser.isPresent()) {
			User userEntity = optionalUser.get();
			return ir.findAllByUser(userEntity);
		}
		return ir.findAllByUser(new User());
	}
	
//	public Iterable<Item> getAllItems() {
//		 return ir.findAll();
//	}
	
	public void CreateItem(Item item, long userId) {
		
		Optional<User> optionalUser =  ur.findById(userId);
		
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
		CheckPendingClaims();
		return ir.findByOfferedTrue();
	}
	
//	public List<Item> getAllItemsSortedByDate(){
//		return ir.findAllByOrderByExpirationDate();
//	}
	
	
	public Item FindById(long itemid) {
		Optional<Item> optionalItem =  ir.findById(itemid);
		
		if(optionalItem.isPresent()) {
			Item itemEntity = optionalItem.get();
			return itemEntity;
		}
		return new Item();
	}
	
	public void updateOffered(boolean offered, long itemId) {
		Item item = FindById(itemId);
		item.setOffered(offered);
		ir.save(item);
	}
	
	public void CheckPendingClaims() {
		// Stap 1: Find all claims via repository
		// Stap 2: Loop met een for-loop en vraag de data op
		// Stap 3: Vergelijk of de duration tussen dat moment en now is meer dan 300 seconden
		// Stap 4: Als dat zo is, remove ze uit de lijst (ik bedoel van de claim wordt de claim op decline gezet)
		// Stap 5: Geef lijst met overbleven claims terug
		
		List <Claim> claims = (List<Claim>) cr.findAllByStatus(Status.PENDING);
		System.out.println(LocalDateTime.now());
		
		for (int i = 0; i < claims.size(); i++) {
			System.out.println(claims.get(i).getId());
			System.out.println(claims.get(i).getRequestDate());
			Duration tussentijd = Duration.between(claims.get(i).getRequestDate(), LocalDateTime.now());
			System.out.println(tussentijd.getSeconds());
			if (tussentijd.getSeconds() > 30) {
				claims.get(i).setStatus(Status.DECLINED);
				claims.get(i).getItem().setOffered(true);
				cr.save(claims.get(i));
			}
		}
		System.out.println("Hier gaan we alle claims filteren");
	}
	
	public long count() {
		return ir.count();
	}
	
}	

