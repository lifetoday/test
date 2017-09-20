package com.ait.interview.domain;

public interface UserLocation {
	public Long getUserId();

	public String getUserName();

	public Location getLocation();

	public Integer getCountChat();

	public void setCountChat(Integer i);

	public Chat getLatestChat();

	public void setLatestChat(Chat chat);
}
