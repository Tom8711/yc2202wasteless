package nl.yc2202.Wasteless.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.yc2202.Wasteless.domein.Claim;
import nl.yc2202.Wasteless.persistence.ClaimService;

@RestController
public class ClaimEndpoint {
	
	@Autowired
	ClaimService cs;
	
	@PostMapping ("/claim/{itemid}/createclaim")
	public void createClaim (@PathVariable("itemid") long itemid) {
		System.out.println(itemid);
		cs.createClaim(itemid);
	}
	
	@PostMapping("/claim/{itemid}/accept")
	public void changeClaimAccept(@PathVariable("itemid") long itemid) {
		cs.changeClaimAccept(itemid);
	}
	

	@PostMapping("/claim/{itemid}/decline")
	public void changeClaimDeclined(@PathVariable("claimid") long claimid) {
		System.out.println(claimid);
		cs.changeClaimDecline(claimid);
	}
	
	@PostMapping("/claim/{claim}/pending")
	public void changeClaimPending(@PathVariable("claimid") long claimid) {
		System.out.println(claimid);
		cs.changeClaimPending(claimid);
	}

	@GetMapping("/claim/{itemid}/getclaims")	
	public Iterable<Claim> getClaims(@PathVariable ("itemid") long itemid) {
		return cs.getAllClaimsByItemId(itemid);
	}
}
		
