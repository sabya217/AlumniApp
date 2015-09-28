package org.practice.webapp.dto;

import java.util.HashMap;
import java.util.Map;

public class UserDetails {
	
	public enum Geek {
		MAX("Nerdy"),MIN("last bencher"),AVERAGE("ideal");
		
		private String feature;
		Geek(String feature) {
			this.feature = feature;
		}
		public String getFeature() {
			return feature;
		}
		
		public static Geek getGeek(int value) {
			if(value == 3)
				return Geek.MAX;
			if(value==2)
				return Geek.AVERAGE;
			else
				return Geek.MIN;
		}
	}
	
	public enum Fun {
		MAX("Cool"),MIN("Boring"),AVERAGE("Fine");
		
		private String feature;
		Fun(String feature) {
			this.feature = feature;
		}
		public String getFeature() {
			return feature;
		}
		public static Fun getFun(int value) {
			if(value == 3)
				return MAX;
			if(value==2)
				return AVERAGE;
			else
				return MIN;
		}
	}
	
	public enum Sports {
		MAX("You were extremy sporty"),MIN("You avoided sports"), AVERAGE("You played only sometimes !");
		
		private String feature;
		Sports(String feature) {
			this.feature = feature;
		}
		public String getFeature() {
			return feature;
		}
		public static Sports getSports(int value) {
			if(value == 3)
				return MAX;
			if(value==2)
				return AVERAGE;
			else
				return MIN;
		}
	}

	private String userId;
	private Geek geek;
	private Fun fun;
	private Sports sports;
	private String description;
	
	private Map<String, String> messages = new HashMap<String, String>();

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Geek getGeek() {
		return geek;
	}

	public void setGeek(Geek geek) {
		this.geek = geek;
	}

	public Fun getFun() {
		return fun;
	}

	public void setFun(Fun fun) {
		this.fun = fun;
	}

	public Sports getSports() {
		return sports;
	}

	public void setSports(Sports sports) {
		this.sports = sports;
	}

	public Map<String, String> getMessages() {
		return new HashMap<String, String>(this.messages);
	}

	public void addMessages(String message) {
		messages.put("self",message);
	}
	
	public void addMessages(String author,String message) {
		messages.put(author,message);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
