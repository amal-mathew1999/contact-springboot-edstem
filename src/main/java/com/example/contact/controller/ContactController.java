package com.example.contact.controller;


import com.example.contact.Entity.Contact;
import com.example.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact){
        Contact newContact=contactService.createContact(contact);
        return new ResponseEntity<>(newContact, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Contact>> getAllContacts(){
        List<Contact> contactList= contactService.fetchAllContacts();
        return new ResponseEntity<>(contactList,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id){
        contactService.deleteContact(id);
        return new ResponseEntity<>("Contact deteted with id "+id,HttpStatus.OK);
    }
}
