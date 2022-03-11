package nl.yc2202.Wasteless.persistence;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.yc2202.Wasteless.domein.Chat;
import nl.yc2202.Wasteless.domein.ChatContent;


@Service
public class ChatContentService {
	
	@Autowired
	ChatContentRepository ccr;
	
	@Autowired
	ChatRepository cr;
	
	public void createChatContent(String content, long chatid) {
		
		Optional<Chat> optionalChat =  cr.findById(chatid);
		
		if(optionalChat.isPresent()) {
			Chat chatEntity = optionalChat.get();
			ChatContent chatContent = new ChatContent();
			chatContent.setChat(chatEntity);
			chatContent.setContent(content);
			chatContent.setMessageTime(LocalDateTime.now());
			ccr.save(chatContent);
		}
	}
}
