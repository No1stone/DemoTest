package com.example.demo.model;

public class WebexMessageModelData {
	
	private String id;
	private String roomId;
	private String roomType;
	private String personId;
	private String personEmail;
	private String created;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getPersonEmail() {
		return personEmail;
	}
	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	@Override
	public String toString() {
		return "WebexMessageModelData [id=" + id + ", roomId=" + roomId + ", roomType=" + roomType + ", personId="
				+ personId + ", personEmail=" + personEmail + ", created=" + created + "]";
	}
	
	
	
}
