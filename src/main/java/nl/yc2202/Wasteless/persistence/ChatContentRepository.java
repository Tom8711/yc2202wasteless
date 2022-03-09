package nl.yc2202.Wasteless.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import nl.yc2202.Wasteless.domein.Chat;
import nl.yc2202.Wasteless.domein.ChatContent;


public interface ChatContentRepository extends CrudRepository<ChatContent, Long>{
	
	List <ChatContent> findAllByChat(Chat chat);

}
