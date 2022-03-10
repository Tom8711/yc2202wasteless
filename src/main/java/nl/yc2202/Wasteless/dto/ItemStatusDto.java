package nl.yc2202.Wasteless.dto;


import nl.yc2202.Wasteless.domein.Item;
import nl.yc2202.Wasteless.persistence.Status;

public class ItemStatusDto {
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	private Item item;
	private Status status;

}
