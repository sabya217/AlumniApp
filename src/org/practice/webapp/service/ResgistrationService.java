package org.practice.webapp.service;

import java.util.Map;
import org.practice.webapp.config.AlumniConfig;
import org.practice.webapp.dto.User;

public class ResgistrationService {

	private StringBuilder message = new StringBuilder();
	private boolean status;
	private User user;
	
	public void process(Map<String, String[]> parameterMap) {
		String userId = parameterMap.containsKey(AlumniConfig.USER_ID)?parameterMap.get(AlumniConfig.USER_ID)[0]:null;
		if(userId == null || userId.trim().equals("")) {
			message.append("User Id can not be empty.");
			return;
		}
		String userName = parameterMap.containsKey(AlumniConfig.USER_NAME)?parameterMap.get(AlumniConfig.USER_NAME)[0]:null;
		if(userName == null || userName.trim().equals("")) {
			message.append(" User Name can not be empty.");
			return;
		}
		String course = parameterMap.containsKey(AlumniConfig.COURSE)?parameterMap.get(AlumniConfig.COURSE)[0]:null;
		if(course == null || course.trim().equals("")) {
			message.append(" Course can not be empty.");
			return;
		}
		String yearValue = parameterMap.containsKey(AlumniConfig.YEAR_OF_PASSING)?parameterMap.get(AlumniConfig.YEAR_OF_PASSING)[0]:null;
		int year = 0;
		if(yearValue == null || yearValue.trim().equals("")) {
			message.append(" Year of passing must be a number.");
			return;
		} else {
			try {
				year = Integer.parseInt(yearValue);
			} catch(NumberFormatException e) {
				message.append(" Year of passing must be a number.");
				return;
			}
		}
		String phoneNo = parameterMap.containsKey(AlumniConfig.PHONE_NO)?parameterMap.get(AlumniConfig.PHONE_NO)[0]:null;
		
		user = new User.Builder()
					.userId(userId)
					.userName(userName)
					.course(course)
					.year(year)
					.phoneNo(phoneNo)
					.build();
		status = true;
	}

	public String getMessage() {
		return message.toString();
	}

	public boolean status() {
		return status;
	}

	public User getUser() {
		return user;
	}
}
