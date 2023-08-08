package com.example.contact.service;

import com.example.contact.Entity.Contact;

import java.util.List;

public interface ContactService {

    public Contact createContact(Contact contact);
    public List<Contact> fetchAllContacts();
    public void deleteContact(Long id);
}
