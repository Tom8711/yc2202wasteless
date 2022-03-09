package nl.yc2202.Wasteless.domein;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity 
public class Chat {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	long id;
	
	private LocalDateTime timeSended;
	
	@OneToMany (mappedBy = "chat")
	private List<ChatContent> chatContent;
	
	@OneToOne
	private Claim claim;
	
	public Claim getClaim() {
		return claim;
	}
	public void setClaim(Claim claim) {
		this.claim = claim;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public List<ChatContent> getChatContent() {
		return chatContent;
	}
	public void setChatContent(List<ChatContent> chatContent) {
		this.chatContent = chatContent;
	}
	public LocalDateTime getTimeSended() {
		return timeSended;
	}
	public void setTimeSended(LocalDateTime timeSended) {
		this.timeSended = timeSended;
	}

	

	
	
	
	
}
