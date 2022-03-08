package nl.yc2202.Wasteless.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@PostMapping("/claim/{claimid}/accept")
	public void changeClaimAccept(@PathVariable("claimid") long claimid) {
		System.out.println(claimid);
		cs.changeClaimAccept(claimid);
	}
	
	@PostMapping("/claim{claimid}/decline")
	public void changeClaimDeclined(@PathVariable("claimid") long claimid) {
		System.out.println(claimid);
		cs.changeClaimDecline(claimid);
	}
	
	@PostMapping("/claim{claimid}/pending")
	public void changeClaimPending(@PathVariable("claimid") long claimid) {
		System.out.println(claimid);
		cs.changeClaimPending(claimid);
	}
	
}
