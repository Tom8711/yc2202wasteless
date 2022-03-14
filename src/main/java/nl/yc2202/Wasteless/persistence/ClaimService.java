package nl.yc2202.Wasteless.persistence;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.yc2202.Wasteless.domein.Chat;
import nl.yc2202.Wasteless.domein.Claim;
import nl.yc2202.Wasteless.domein.Item;
import nl.yc2202.Wasteless.domein.User;

@Service
public class ClaimService {
	
	@Autowired
	ClaimRepository cr;
	
	@Autowired
	ItemService is;
	
	@Autowired 
	ItemRepository ir;
	
	@Autowired
	ChatRepository chr;
	
	@Autowired
	ChatContentService ccs;
	
	@Autowired
	UserRepository ur;
	
	public List<Claim> getAllClaimsDoneByUserId(long userId) {
		Optional<User> optionalUser =  ur.findById(userId);
		
		if(optionalUser.isPresent()) {
			User userEntity = optionalUser.get();
			return cr.findAllByUser(userEntity);
		}
		return cr.findAllByUser(new User());
		
	}
		
	public void createClaim (long itemid, String chatContent, long userid) {
		
		Item itemEntity = is.FindById(itemid); 
		itemEntity.setOffered(false);
		Claim claim = new Claim();
		claim.setItem(itemEntity);
		//Store claim with responding user
		Optional<User> optionalUser = ur.findById(userid);
		User user = optionalUser.get();
		claim.setUser(user);
		cr.save(claim);
		changeClaimPending(claim.getId());
		//Create a new chat
		Chat chat = new Chat();
		chat.setClaim(claim);
		chr.save(chat);
		if(chatContent.isBlank()==false) {
			ccs.createChatContent(chatContent, chat.getId());				
		}
	}

	public void changeClaimAccept(long itemid) {
		Optional<Item> optionalItem = ir.findById(itemid);
		if (optionalItem.isPresent()) {
			Item item = optionalItem.get();
			Optional <Claim> optionalClaim = cr.findFirstByItemOrderByRequestDateDesc(item);
				if (optionalClaim.isPresent()) {
					Claim claim = optionalClaim.get();
					claim.setStatus(Status.APPROVED);
					cr.save(claim);	
				}
		}	
	}
	
	public void changeClaimDecline(long itemid) {
		Optional<Item> optionalItem = ir.findById(itemid);
		if (optionalItem.isPresent()) {
			Item item = optionalItem.get();
			Optional <Claim> optionalClaim = cr.findFirstByItemOrderByRequestDateDesc(item);
				if (optionalClaim.isPresent()) {
					Claim claim = optionalClaim.get();
					claim.setStatus(Status.DECLINED);
					cr.save(claim);	
				}
		}
	}
	
	public void changeClaimPending(long claimid) {
		Claim claim = cr.findById(claimid).get();
		claim.setStatus(Status.PENDING);
		cr.save(claim);
	}
	

	public Iterable<Claim> getAllClaimsByItemId(long itemId) {
		Optional<Item> optionalItem =  ir.findById(itemId);

			Item itemEntity = optionalItem.get();
			System.out.println(itemEntity);
			return cr.findAllByItem(itemEntity);
		
	}
	
	public Iterable<Claim> getAllPendingClaimsByItemId(long itemId) {
		Optional<Item> optionalItem =  ir.findById(itemId);
			
		return cr.findAllByStatusAndItem(Status.PENDING, optionalItem);
		
	}
	
	public Claim findLatestClaim(Item item) {
		Optional <Claim> optionalClaim = cr.findFirstByItemOrderByRequestDateDesc(item);
	
	if(optionalClaim.isPresent()) {
		Claim claimEntity = optionalClaim.get();
		return claimEntity;
	}
	return new Claim();
}

//	public Claim findById(long claimid) {
//		Optional<Claim> optionalClaim =  cr.findById(claimid);
//		
//		if(optionalClaim.isPresent()) {
//			Claim claimEntity = optionalClaim.get();
//			return claimEntity;
//		}
//		return new Claim();
//	}

}