package nl.yc2202.Wasteless.dto;

import nl.yc2202.Wasteless.domein.Item;

public class CreateItemDto {

	private Item item;
	private long userId;
	
	
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
}
