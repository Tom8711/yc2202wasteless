package nl.yc2202.Wasteless.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nl.yc2202.Wasteless.domein.ChatContent;
import nl.yc2202.Wasteless.persistence.ChatContentService;

@RestController
public class ChatContentEndpoint {
	
	@Autowired
	ChatContentService ccs;
	
	@PostMapping("/chatcontent/{chatid}/create")
	public void createItem(@RequestBody ChatContent chatContent, @PathVariable long chatid) {
		System.out.println("test");
		ccs.CreateChatContent(chatContent, chatid);
	}

}
