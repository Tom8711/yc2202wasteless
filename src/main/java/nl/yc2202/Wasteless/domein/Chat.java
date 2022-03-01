package nl.yc2202.Wasteless.domein;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Chat {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	long id;
	private String message;
	private LocalDate dateSend;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDate getDateSend() {
		return dateSend;
	}
	public void setDateSend(LocalDate dateSend) {
		this.dateSend = dateSend;
	}
	
	
	
	
}
