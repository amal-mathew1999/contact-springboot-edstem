package com.example.contact.repository;

import com.example.contact.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {

    public List<Contact> findByPhoneNumber(String phoneNumber);
}
