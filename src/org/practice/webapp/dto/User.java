package org.practice.webapp.dto;

public class User {

	private String userName;
	private String userId;
	private int year;
	private String course;
	private String phoneNo;
	
	public User() {
	}

	public static class Builder {
		private String userName;
		private String userId;
		private int year;
		private String course;
		private String phoneNo;

		public Builder() {
		}

		public Builder userName(String userName) {
			this.userName = userName;
			return this;
		}

		public Builder userId(String userId) {
			this.userId = userId;
			return this;
		}

		public Builder year(int year) {
			this.year = year;
			return this;
		}

		public Builder course(String course) {
			this.course = course;
			return this;
		}

		public Builder phoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
			return this;
		}
		
		public User build() {
			return new User(this);
		}
	}
	
	private User(Builder builder) {
		userName = builder.userName;
		userId = builder.userId;
		course = builder.course;
		phoneNo = builder.phoneNo;
		year = builder.year;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserId() {
		return userId;
	}

	public int getYear() {
		return year;
	}

	public String getCourse() {
		return course;
	}

	public String getPhoneNo() {
		return phoneNo;
	}


}
