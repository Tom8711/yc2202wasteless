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
		cs.createClaim(itemid);
	}
	

}
