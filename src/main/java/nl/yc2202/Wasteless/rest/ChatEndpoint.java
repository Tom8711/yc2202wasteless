package nl.yc2202.Wasteless.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import nl.yc2202.Wasteless.domein.Chat;
import nl.yc2202.Wasteless.dto.GetAllUserChatsDto;
import nl.yc2202.Wasteless.persistence.ChatService;



@RestController
public class ChatEndpoint {
	
	@Autowired
	ChatService cs;
	
	@GetMapping("/chat")
	public void chat() {
		System.out.println("the chat works");
	}
	
	@GetMapping("/getAllChats/{userId}")
	public List<GetAllUserChatsDto> getAllChats(@PathVariable long userId) {
		List<GetAllUserChatsDto> result = new ArrayList<GetAllUserChatsDto>();
		
		List<Chat> chats = cs.getAllChats(userId);
		for (Chat c : chats) {
			GetAllUserChatsDto chatDto = new GetAllUserChatsDto();
			chatDto.setId(c.getId());
			chatDto.setClaimId(c.getClaim().getId());
			chatDto.setTimeSended(c.getChatContent().get(c.getChatContent().size() - 1).getMessageTime());
			chatDto.setName(c.getClaim().getUser().getUserName());
			chatDto.setChatSize(c.getChatContent().size());
			chatDto.setLatestMsg(c.getChatContent().get(c.getChatContent().size() - 1).getContent());
			result.add(chatDto);
		}
		return result;
	}
	
	@GetMapping("/htmlpage")
	public void toHTML() {
		System.out.println("HTML works");
	}
	
//	@GetMapping("/chat/{claimid}/getchat")
//	public Chat getChatFromClaim(@PathVariable long claimid) {
//		return cs.findChat(claimid);
//	}
}
