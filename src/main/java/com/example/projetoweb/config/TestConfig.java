package com.example.projetoweb.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.projetoweb.entities.Category;
import com.example.projetoweb.entities.Order;
import com.example.projetoweb.entities.User;
import com.example.projetoweb.entities.enums.OrderStatus;
import com.example.projetoweb.repositories.CategoryRepository;
import com.example.projetoweb.repositories.OrderRepository;
import com.example.projetoweb.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	@Autowired
	OrderRepository OrderRepository;
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		Category c1 = new Category(null, "Eletronics");
		Category c2 = new Category(null, "Books");
		Category c3 = new Category(null, "Software");
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3));

		User u1 = new User(null, "mayk", "mayk@gmail.com", "1234", "3333");
		User u2 = new User(null, "felipe", "felipe@gmail.com", "99999", "1204");
		User u3 = new User(null, "jean", "jean@gmail.com", "323311", "9103");
		userRepository.saveAll(Arrays.asList(u1, u2, u3));

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.CANCELED, u1);
		OrderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}

}
