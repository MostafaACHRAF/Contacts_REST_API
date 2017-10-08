package com.ContactAngular2.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ContactAngular2.dao.ContactRepository;
import com.ContactAngular2.entities.Contact;

@RestController
@CrossOrigin("*")
public class ContactService {

	@Autowired
	private ContactRepository contactRepo;
	
	
	@RequestMapping(value="/contacts", method=RequestMethod.GET)
	public List<Contact> listContacts() {
		return contactRepo.findAll();
	}
	
	
	@RequestMapping(value="/contacts/{id}", method=RequestMethod.GET)
	public Contact getContact(@PathVariable int id) {
		return contactRepo.findOne(id);
	}
	
	
	@RequestMapping(value="/contacts", method=RequestMethod.POST)
	public Contact save(@RequestBody Contact c) {
		return contactRepo.save(c);
	}
	
	@RequestMapping(value="/contacts/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable int id) {
		contactRepo.delete(id);
		return true;
	}
	
	
	@RequestMapping(value="/contacts/{id}", method=RequestMethod.PUT)
	public Contact update(@RequestBody Contact c, @PathVariable int id) {
		c.setId(id);
		return contactRepo.save(c);
	}
	
	@RequestMapping(value="/chercher", method=RequestMethod.GET)
	public Page<Contact> chercher(@RequestParam(name="key", defaultValue="") String key, @RequestParam(name="page", defaultValue="0") int page, @RequestParam(name="size", defaultValue="5") int size) {
		return contactRepo.chercher(key, new PageRequest(page, size));
	}
}
