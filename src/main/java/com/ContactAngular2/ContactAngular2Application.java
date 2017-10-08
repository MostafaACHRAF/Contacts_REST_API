package com.ContactAngular2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ContactAngular2.dao.ContactRepository;
import com.ContactAngular2.entities.Contact;

@SpringBootApplication
public class ContactAngular2Application implements CommandLineRunner {
	
	@Autowired
	ContactRepository contactRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ContactAngular2Application.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		contactRepo.save(new Contact("mostafa", "achraf", df.parse("07/12/1994"), 601943183, "mostafaegma@gmail.com", "img122"));
		contactRepo.save(new Contact("achraf", "ali", df.parse("09/10/1998"), 601943183, "achrafali@gmail.com", "img145"));
		contactRepo.save(new Contact("john", "telerson", df.parse("27/03/1967"), 601943183, "john@gmail.com", "img100"));
		contactRepo.save(new Contact("mathieu", "ervey", df.parse("19/01/1977"), 601943183, "mathieu@gmail.com", "img055"));
		
		contactRepo.findAll().forEach(c -> {
			System.out.println(c.getNom());
		});
	}
}
