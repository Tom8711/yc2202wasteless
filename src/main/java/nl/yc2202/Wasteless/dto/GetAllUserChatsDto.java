package nl.yc2202.Wasteless.dto;

import java.time.LocalDateTime;


public class GetAllUserChatsDto {
	
	private long id;
	private long claimId;
	private String latestMsg;
	private String name;
	private int chatSize;
	private LocalDateTime timeSended;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getClaimId() {
		return claimId;
	}
	public void setClaimId(long claimId) {
		this.claimId = claimId;
	}
	public LocalDateTime getTimeSended() {
		return timeSended;
	}
	public void setTimeSended(LocalDateTime timeSended) {
		this.timeSended = timeSended;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLatestMsg() {
		return latestMsg;
	}
	public void setLatestMsg(String latestMsg) {
		this.latestMsg = latestMsg;
	}
	public int getChatSize() {
		return chatSize;
	}
	public void setChatSize(int chatSize) {
		this.chatSize = chatSize;
	}
}
