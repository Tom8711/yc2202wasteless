package nl.yc2202.Wasteless.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.yc2202.Wasteless.persistence.ChatService;



@RestController
public class ChatEndpoint {
	
	@Autowired
	ChatService cs;
	
	@GetMapping("/chat")
	public void chat() {
		System.out.println("the chat works");
	}
	
	@GetMapping("/htmlpage")
	public void toHTML() {
		System.out.println("HTML works");
	}
	
	@PostMapping("/chat/{claimid}/createchat")
	public void createClaim (@PathVariable long claimid) {
		cs.createChat (claimid);
	}
}
