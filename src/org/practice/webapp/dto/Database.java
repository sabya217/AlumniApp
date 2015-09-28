package org.practice.webapp.dto;

import java.util.HashMap;
import java.util.Map;

import org.practice.webapp.dto.UserDetails.Fun;
import org.practice.webapp.dto.UserDetails.Geek;
import org.practice.webapp.dto.UserDetails.Sports;

public class Database {

	private static Map<String, UserDetails> details = new HashMap<String, UserDetails>();
	
	private static Map<String, User> idToUser = new HashMap<String, User>();
	
	public static void store(User user) {
		idToUser.put(user.getUserId(), user);
	}
	
	public static void store(UserDetails userDetails) {
		details.put(userDetails.getUserId(), userDetails);
	}
	
	public static UserDetails getUserDetails(String userName, int year) {
		return details.get(userName+"-"+year);
	}
	
	public static UserDetails getUserDetails(String userId) {
		return details.get(userId);
	}
	
	public static User getUser(String userId) {
		return idToUser.get(userId);
	}
	
	public static UserDetails getUserDetails(User user) {
		if(details.containsKey(user.getUserId()))
			return details.get(user.getUserId());
		UserDetails userDetails = details.get(user.getUserName()+"-"+user.getYear());
		if(userDetails == null) {
			userDetails = generateDetails();
			details.put(user.getUserId(), userDetails);
			details.put(user.getUserName()+"-"+user.getYear(), userDetails);
		} else {
			details.put(user.getUserId(), userDetails);
		}
		return userDetails;
	}

	private static UserDetails generateDetails() {
		UserDetails userDetails = new UserDetails();
		userDetails.setFun(Fun.AVERAGE);
		userDetails.setGeek(Geek.AVERAGE);
		userDetails.setSports(Sports.MIN);
		return userDetails;
	}
}
