package nl.yc2202.Wasteless.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.yc2202.Wasteless.domein.Claim;
import nl.yc2202.Wasteless.domein.Item;
import nl.yc2202.Wasteless.dto.CreateClaimDto;
import nl.yc2202.Wasteless.persistence.ClaimService;

@RestController
public class ClaimEndpoint {
	
	@Autowired
	ClaimService cs;
	
	@GetMapping("/claim/{userId}/getclaimsdone")
	public Iterable<Claim> getAllClaimsDoneByUserId(@PathVariable("userId") long userId) {
		return cs.getAllClaimsDoneByUserId(userId);
	}
	
	@PostMapping ("/claim/createclaim")
	public void createClaim (@RequestBody CreateClaimDto createClaimDto) {
		System.out.println("test");
		cs.createClaim(createClaimDto.getItemId(), createClaimDto.getChatContentMessage(), createClaimDto.getUserId());
	}
	
	@PostMapping("/claim/{claimid}/accept")
	public void changeClaimAccept(@PathVariable("claimid") long claimid) {
		System.out.println(claimid);
		cs.changeClaimAccept(claimid);
	}
	

	@PostMapping("/claim/{claimid}/decline")
	public void changeClaimDeclined(@PathVariable("claimid") long claimid) {
		System.out.println(claimid);
		cs.changeClaimDecline(claimid);
	}
	
	@PostMapping("/claim/{claimid}/pending")
	public void changeClaimPending(@PathVariable("claimid") long claimid) {
		System.out.println(claimid);
		cs.changeClaimPending(claimid);
	}

	@GetMapping("/claim/{itemid}/getclaims")	
	public Iterable<Claim> getClaims(@PathVariable ("itemid") long itemid) {
		return cs.getAllClaimsByItemId(itemid);
	}
	
	//Get all claims (should be one) that are pending and are connected to the given itemid 
	@GetMapping("/claim/{itemid}/getpendingclaimsbyitemid")	
	public Iterable<Claim> getPendingClaimsItem(@PathVariable ("itemid") long itemid) {
		return cs.getAllPendingClaimsByItemId(itemid);
	}
	
}
		
