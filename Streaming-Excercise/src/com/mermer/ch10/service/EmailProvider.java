package com.mermer.ch10.service;

import com.mermer.ch10.User;

public interface EmailProvider {
	String getEmailString(User user);

}
