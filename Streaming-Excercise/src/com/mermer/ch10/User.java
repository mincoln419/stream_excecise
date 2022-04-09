package com.mermer.ch10;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class User {
	private int id;
	private String name;
	private String emailAddress;
	private boolean isVerified;
	private List<Integer> friendUserIds;
	
	public User(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.emailAddress = builder.emailAddress;
		this.isVerified = builder.isVerified;
		this.friendUserIds = builder.friendUserIds;
	}
	
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Optional<String> getEmailAddress() {
		return Optional.of(emailAddress);
	}
	
	public boolean isVerified() {
		return isVerified;
	}
	
	
	public List<Integer> getFriendUserIds() {
		return friendUserIds;
	}
	
	public static Builder builder(int id, String name) {
		return new Builder(id, name);
	}
	public static class Builder {
		private int id;
		private String name;
		public String emailAddress;
		public boolean isVerified;
		public List<Integer> friendUserIds = new ArrayList<>();
		
		public Builder(int id, String name) {
			this.id = id;
			this.name = name;
		}
		
		/*
		 * public Builder withEmailAddress(String emailAddress) { this.emailAddress =
		 * emailAddress; return this; }
		 * 
		 * public Builder withVerified(boolean isVerified) { this.isVerified =
		 * isVerified; return this; }
		 * 
		 * public Builder withfriendUserIds(List<Integer> freiendsUserIds) {
		 * this.friendUserIds = freiendsUserIds; return this; }
		 */
		//-> Comsumer를 통해 method 단순화
		public Builder with(Consumer<Builder> consumer) {
			consumer.accept(this);
			return this;
		}
		
		
		public User build() {
			return new User(this);
		}
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", " + (name != null ? "name=" + name + ", " : "")
				+ (emailAddress != null ? "emailAddress=" + emailAddress + ", " : "") + "isVerified=" + isVerified
				+ ", " + (friendUserIds != null ? "friendUserIds=" + friendUserIds : "") + "]";
	}



}
