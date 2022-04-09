package com.mermer.ch10.service;

import com.mermer.ch10.User;

public class MakeMoreFriendEmailProvider implements EmailProvider {

	@Override
	public String getEmailString(User user) {
		return "'Make More Friend Email Address' email for " + user.getName();
	}

}
