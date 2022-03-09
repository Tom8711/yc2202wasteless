package nl.yc2202.Wasteless.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.yc2202.Wasteless.domein.Chat;
import nl.yc2202.Wasteless.domein.Claim;

@Service
public class ChatService {
	
	@Autowired
	ChatRepository cr;
	
	@Autowired
	ClaimService cs;
	
	public void createChat (long claimid) {
		
		Claim claimEntity = cs.findById(claimid);
		Chat chat = new Chat();
		chat.setClaim(claimEntity);
		cr.save(chat);
	}

}
