package com.mermer.ch10;

import java.util.Arrays;
import java.util.List;

import com.mermer.ch10.service.BasicPriceProcessor;
import com.mermer.ch10.service.DiscountProcessor;
import com.mermer.ch10.service.EmailProvider;
import com.mermer.ch10.service.EmailSender;
import com.mermer.ch10.service.MakeMoreFriendEmailProvider;
import com.mermer.ch10.service.PriceProcessor;
import com.mermer.ch10.service.TaxPriceProcessor;
import com.mermer.ch10.service.VeryfyYourEmailProvider;

public class Chapter10Section3 {

	public static void main(String[] args) {

		User user1 = User.builder(1, "Alice").with(builder -> {
			builder.emailAddress = "alice@email.com";
			builder.isVerified = false;
			builder.friendUserIds = Arrays.asList(1, 3, 4, 5, 6, 7, 8);
		}).build();

		User user2 = User.builder(2, "Billy").with(builder -> {
			builder.emailAddress = "alice@email.com";
			builder.isVerified = true;
			builder.friendUserIds = Arrays.asList(1, 3, 4, 5, 7, 9, 10);
		}).build();

		User user3 = User.builder(3, "Chalie").with(builder -> {
			builder.emailAddress = "alice@email.com";
			builder.isVerified = true;
			builder.friendUserIds = Arrays.asList(3, 1);
		}).build();

		List<User> users = Arrays.asList(user1, user2, user3);
		
		EmailSender emailSender = new EmailSender();
		EmailProvider verfyYourEmailProvider = new VeryfyYourEmailProvider();
		EmailProvider makemorefriendEmailProvider = new MakeMoreFriendEmailProvider();
		
		//이메일 검증
		emailSender.setEmailProvider(verfyYourEmailProvider);
		users.stream()
			.filter(user -> !user.isVerified())
			.forEach(emailSender::sendEmail);
		
		
		emailSender.setEmailProvider(makemorefriendEmailProvider);
		users.stream()
			.filter(User::isVerified)
			.filter(user -> user.getFriendUserIds().size() <= 5)
			.forEach(emailSender::sendEmail);
		
		
		emailSender.setEmailProvider(user -> "'Play With Friends' email for " + user.getName());
		users.stream()
			.filter(User::isVerified)
			.filter(user -> user.getFriendUserIds().size() > 5)
			.forEach(emailSender::sendEmail);
		

	}

}
