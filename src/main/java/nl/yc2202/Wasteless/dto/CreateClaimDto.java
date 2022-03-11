package nl.yc2202.Wasteless.dto;

public class CreateClaimDto {
	
	private String chatContentMessage;
	private long itemId;
	private long userId;
	
	
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getChatContentMessage() {
		return chatContentMessage;
	}
	public void setChatContentMessage(String chatContentMessage) {
		this.chatContentMessage = chatContentMessage;
	}
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	

}
