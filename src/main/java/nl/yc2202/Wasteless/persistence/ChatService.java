package nl.yc2202.Wasteless.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.yc2202.Wasteless.domein.Chat;
import nl.yc2202.Wasteless.domein.Claim;

@Service
public class ChatService {
	
	@Autowired
	ChatRepository cr;
	
	public void createChat (Claim claim) {
		
		Chat chat = new Chat();
		chat.setClaim(claim);
		cr.save(chat);
	}
	
//	public Chat findChat(long claimid) {
//		return cr.findByClaimId(claimid);
//	}

}
