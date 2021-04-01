package com.example.projetoweb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.projetoweb.entities.User;
import com.example.projetoweb.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "mayk", "mayk@gmail.com", "1234", "3333");
		User u2 = new User(null, "felipe", "felipe@gmail.com", "99999", "1204");
		userRepository.saveAll(Arrays.asList(u1, u2));
	}

}
