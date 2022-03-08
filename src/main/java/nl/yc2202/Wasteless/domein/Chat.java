package nl.yc2202.Wasteless.domein;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Chat {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getTimeSended() {
		return timeSended;
	}
	public void setTimeSended(LocalDateTime timeSended) {
		this.timeSended = timeSended;
	}
	private String content;
	private LocalDateTime timeSended;
	

	
	
	
	
}
