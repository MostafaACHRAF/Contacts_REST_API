package com.ContactAngular2.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ContactAngular2.entities.Contact;

public interface ContactRepository  extends JpaRepository<Contact, Integer> {

	@Query("select c from Contact c where c.nom like %:key%  or c.prenom like %:key% order by c.id desc")
	public Page<Contact> chercher(@Param("key") String key, Pageable p);
}
