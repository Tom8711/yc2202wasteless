package nl.yc2202.Wasteless.persistence;

import java.util.Date;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;


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
		Item itemEntity = is.FindById(itemid);
		itemEntity.setOffered(false);
		Claim claim = new Claim();
		itemEntity.setClaim(claim);
		cr.save(claim);
	}

	public void changeClaimAccept(long claimid) {
		// TODO Auto-generated method stub
		Claim claim = cr.findById(claimid).get();
		claim.setStatus(Status.APPROVED);
		cr.save(claim);
		
	}
	

}