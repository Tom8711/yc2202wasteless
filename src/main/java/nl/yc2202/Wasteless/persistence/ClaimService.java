package nl.yc2202.Wasteless.persistence;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.yc2202.Wasteless.domein.Claim;
import nl.yc2202.Wasteless.domein.Item;
import nl.yc2202.Wasteless.domein.User;

@Service
public class ClaimService {
	
	@Autowired
	ClaimRepository cr;
	
	@Autowired
	ItemService is;
	
	public void createClaim (long itemid) {
	
		Optional<Item> optionalItem = is.FindById(itemid);
		
		if (optionalItem.isPresent()) {
			Item itemEntity = optionalItem.get();
			itemEntity.setOffered(false);
			Claim claim = new Claim();
			itemEntity.setClaim(claim);
			cr.save(claim);
		}

	}

	

}
