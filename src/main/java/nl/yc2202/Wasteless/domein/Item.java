package nl.yc2202.Wasteless.domein;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Item {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	long id;
	private String name;
	private LocalDate expirationDate;
	private int amount;
	private String weight;
	//note foto moet uiteindelijk een blob worden om goed opgeslagen te worden
	private String photo;
	private boolean offered;
	

//	@OneToMany
//	List<Chat> chat1;
	
	public boolean isOffered() {
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getWeightt() {
		return weight;
	}
	public void setWeight(String gewicht) {
		this.weight = gewicht;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	
}