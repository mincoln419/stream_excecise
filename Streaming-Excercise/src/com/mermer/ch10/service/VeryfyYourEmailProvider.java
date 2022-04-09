package com.mermer.ch10.service;

import com.mermer.ch10.User;

public class VeryfyYourEmailProvider implements EmailProvider {

	@Override
	public String getEmailString(User user) {
		return "'Verify Your Email Address' email for " + user.getName();
	}

}
