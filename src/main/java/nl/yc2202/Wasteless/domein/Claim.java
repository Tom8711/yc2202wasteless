package nl.yc2202.Wasteless.domein;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import nl.yc2202.Wasteless.persistence.Status;

@Entity 
public class Claim {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	long id;
	private boolean completed;
	private LocalDate expiryDate;
	private LocalDateTime requestDate = LocalDateTime.now();
	private Status status;
	
	
	@JsonIgnore 
	@OneToOne (mappedBy = "claim")
	private Item item;
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public LocalDateTime getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(LocalDateTime requestDate) {
		this.requestDate = requestDate;
	}
	
	// ENUM getter and setter
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
