package com.mermer.ch8;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.mermer.ch6.Order;
import com.mermer.ch6.User;
import com.mermer.ch8.service.EmailService;
import com.mermer.ch6.Order.OrderStatus;

public class Chapter8Section10 {

	public static void main(String[] args) {

		
		User user1 = new User()
				.setId(101)
				.setName("Alice")
				.setVerified(true)
				.setFriendUserIds(Arrays.asList(201, 202, 203, 204, 207, 208))
				.setEmail("alice@naver.com");
				
		User user2 = new User()
				.setId(102)
				.setName("James")
				.setVerified(false)
				.setFriendUserIds(Arrays.asList(201, 205))
				.setEmail("james@naver.com");
		User user3 = new User()
				.setId(103)
				.setName("BigFoot")
				.setVerified(false)
				.setFriendUserIds(Arrays.asList(204, 206, 207))
				.setEmail("bigFoot@naver.com");
		User user4 = new User()
				.setId(103)
				.setName("BigFoot")
				.setVerified(false)
				.setFriendUserIds(Arrays.asList(204, 206, 207))
				.setEmail("bigFoot@naver.com");
		User user5 = new User()
				.setId(103)
				.setName("BigFoot")
				.setVerified(true)
				.setFriendUserIds(Arrays.asList(204, 206, 207))
				.setEmail("bigFoot@naver.com");
		User user6 = new User()
				.setId(103)
				.setName("BigFoot")
				.setVerified(false)
				.setFriendUserIds(Arrays.asList(204, 206, 207))
				.setEmail("bigFoot@naver.com");
		User user7 = new User()
				.setId(103)
				.setName("BigFoot")
				.setVerified(false)
				.setFriendUserIds(Arrays.asList(204, 206, 207))
				.setEmail("bigFoot@naver.com");
		User user8 = new User()
				.setId(103)
				.setName("BigFoot")
				.setVerified(false)
				.setFriendUserIds(Arrays.asList(204, 206, 207))
				.setEmail("bigFoot@naver.com");
		User user9 = new User()
				.setId(103)
				.setName("BigFoot")
				.setVerified(false)
				.setFriendUserIds(Arrays.asList(204, 206, 207))
				.setEmail("bigFoot@naver.com");
		User user10 = new User()
				.setId(103)
				.setName("BigFoot")
				.setVerified(false)
				.setFriendUserIds(Arrays.asList(204, 206, 207))
				.setEmail("bigFoot@naver.com");
		User user11 = new User()
				.setId(103)
				.setName("BigFoot")
				.setVerified(false)
				.setFriendUserIds(Arrays.asList(204, 206, 207))
				.setEmail("bigFoot@naver.com");
		User user12 = new User()
				.setId(103)
				.setName("BigFoot")
				.setVerified(false)
				.setFriendUserIds(Arrays.asList(204, 206, 207))
				.setEmail("bigFoot@naver.com");
		
		
		List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12);

		
		EmailService e = new EmailService();
		long startTime = System.currentTimeMillis();
		users.stream().filter(user -> !user.isVerified())
			.forEach(e::sendVerifyYOurEmailEmail);
		
		long endTime = System.currentTimeMillis();
		System.out.println("Sequencial " + (endTime - startTime));
		
		
		
		startTime = System.currentTimeMillis();
		users.stream().parallel()
			.filter(user -> !user.isVerified())
			.forEach(e::sendVerifyYOurEmailEmail);
		
		endTime = System.currentTimeMillis();
		System.out.println("Pararel " + (endTime - startTime));
		
	}
	

}
