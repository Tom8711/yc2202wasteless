package nl.yc2202.Wasteless.domein;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
public class Item {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	long id;
	private String name;
	private LocalDate expirationDate;
	private String amount;
	//note foto moet uiteindelijk een blob worden om goed opgeslagen te worden
	private String photo;
	private boolean offered;
	
	@ManyToOne
	private User user;
	
	@JsonIgnore
	@OneToMany (mappedBy = "item")
	private List<Claim> claim;

	
	public List<Claim> getClaim() {
		return claim;
	}
	public void setClaim(List<Claim> claim) {
		this.claim = claim;
	}
	public boolean getOffered() {
		return offered;
	}
	public void setOffered(boolean offered) {
		this.offered = offered;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}