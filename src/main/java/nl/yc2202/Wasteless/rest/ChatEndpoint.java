package nl.yc2202.Wasteless.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatEndpoint {
	@GetMapping("/chat/")
	public void chat() {
		System.out.println("the chat works");
	}
	
	@GetMapping("/htmlpage")
	public void toHTML() {
		System.out.println("HTML works");
	}
}
