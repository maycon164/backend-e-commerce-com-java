package com.example.projetoweb.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.projetoweb.entities.Category;
import com.example.projetoweb.entities.Order;
import com.example.projetoweb.entities.OrderItem;
import com.example.projetoweb.entities.Payment;
import com.example.projetoweb.entities.Product;
import com.example.projetoweb.entities.User;
import com.example.projetoweb.entities.enums.OrderStatus;
import com.example.projetoweb.repositories.CategoryRepository;
import com.example.projetoweb.repositories.OrderItemRepository;
import com.example.projetoweb.repositories.OrderRepository;
import com.example.projetoweb.repositories.ProductRepository;
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
	@Autowired
	ProductRepository productRepository;
	@Autowired
	OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		Category c1 = new Category(null, "Eletronics");
		Category c2 = new Category(null, "Books");
		Category c3 = new Category(null, "Computers");
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3));

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		p1.getCategories().add(c2);
		p2.getCategories().add(c1);
		p3.getCategories().addAll(Arrays.asList(c1, c3));
		p4.getCategories().addAll(Arrays.asList(c1, c3));
		p5.getCategories().add(c2);
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		User u1 = new User(null, "mayk", "mayk@gmail.com", "1234", "3333");
		User u2 = new User(null, "felipe", "felipe@gmail.com", "99999", "1204");
		User u3 = new User(null, "jean", "jean@gmail.com", "323311", "9103");
		userRepository.saveAll(Arrays.asList(u1, u2, u3));

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.CANCELED, u1);
		OrderRepository.saveAll(Arrays.asList(o1, o2, o3));
	
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T19:53:07Z"), o1);
		o1.setPayment(pay1);
		OrderRepository.save(o1);
	}

}
