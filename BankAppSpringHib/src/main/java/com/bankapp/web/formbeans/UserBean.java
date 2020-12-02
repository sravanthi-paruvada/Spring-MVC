package com.bankapp.web.formbeans;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserBean {
	
		private Integer uid;

		@NotNull(message = "Username can not be left blank")
		private String username;

		@NotNull(message = "Password can not be left blank")
		private String password;

		@NotNull(message = "User Role can not be left blank")
		private String userType;

		@NotNull(message = "Address can not be left blank")
		private String address;

		@NotNull(message = "Phone number can not be left blank")
		private String phone;

		@NotNull(message = "Email can not be left blank")
		private String email;
		
		
		public UserBean() {
		}

		public Integer getUid() {
			return uid;
		}

		public void setUid(Integer uid) {
			this.uid = uid;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getUserType() {
			return userType;
		}

		public void setUserType(String userType) {
			this.userType = userType;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		

}
