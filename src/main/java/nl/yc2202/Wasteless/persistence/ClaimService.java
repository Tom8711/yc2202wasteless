package nl.yc2202.Wasteless.persistence;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.yc2202.Wasteless.domein.Claim;
import nl.yc2202.Wasteless.domein.Item;

@Service
public class ClaimService {
	
	@Autowired
	ClaimRepository cr;
	
	@Autowired
	ItemService is;
	
	@Autowired 
	ItemRepository ir;
	
	@Autowired
	ChatService cs;
	
	
		
	public void createClaim (long itemid) {
		
			Item itemEntity = is.FindById(itemid);
			itemEntity.setOffered(false);
			Claim claim = new Claim();
			claim.setItem(itemEntity);
			cr.save(claim);
			//Create a new chat
			cs.createChat(claim);
			System.out.println(claim.getRequestDate());
			changeClaimPending(claim.getId());
	}

	public void changeClaimAccept(long claimid) {
		// TODO Auto-generated method stub
		Claim claim = cr.findById(claimid).get();
		claim.setStatus(Status.APPROVED);
		cr.save(claim);
		
	}
	
	public void changeClaimDecline(long claimid) {
		Claim claim = cr.findById(claimid).get();
		claim.setStatus(Status.DECLINED);
		cr.save(claim);
	}
	
	public void changeClaimPending(long claimid) {
		Claim claim = cr.findById(claimid).get();
		claim.setStatus(Status.PENDING);
		System.out.println("Felix 2");
		cr.save(claim);
	}
	

	public Iterable<Claim> getAllClaimsByItemId(long itemId) {
		Optional<Item> optionalItem =  ir.findById(itemId);

			Item itemEntity = optionalItem.get();
			System.out.println(itemEntity);
			return cr.findAllByItem(itemEntity);
		
	}
	
	public Claim findById(long itemid) {
		Optional<Claim> optionalClaim =  cr.findById(itemid);
		
		if(optionalClaim.isPresent()) {
			Claim claimEntity = optionalClaim.get();
			return claimEntity;
		}
		return new Claim();
	}
}