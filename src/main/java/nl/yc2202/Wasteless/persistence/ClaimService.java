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
	
	@Autowired 
	ItemRepository ir;
	
	public void createClaim (long itemid) {
		
			Item itemEntity = is.FindById(itemid);
			itemEntity.setOffered(false);
			Claim claim = new Claim();
			itemEntity.setClaim(claim);
			cr.save(claim);
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
	

	
}