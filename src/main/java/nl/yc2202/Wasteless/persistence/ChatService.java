package nl.yc2202.Wasteless.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.yc2202.Wasteless.domein.Chat;
import nl.yc2202.Wasteless.domein.Claim;

@Service
public class ChatService {
	
	@Autowired
	ChatRepository cr;
	
	@Autowired
	ClaimService ClaimS;
	
	public void createChat (Claim claim) {
		
		Chat chat = new Chat();
		chat.setClaim(claim);
		cr.save(chat);
	}
	
	public List<Chat> getAllChats(long userID){
		List<Chat> allChats = new ArrayList<Chat>();
		List<Claim> claims = ClaimS.getAllClaimsDoneByUserId(userID);
		for(Claim c: claims){
			allChats.add(c.getChat());
		}
		
		return allChats;
		
	}
	
//	public Chat findChat(long claimid) {
//		return cr.findByClaimId(claimid);
//	}

}
