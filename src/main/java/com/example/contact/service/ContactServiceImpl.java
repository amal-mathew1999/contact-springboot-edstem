package com.example.contact.service;

import com.example.contact.Entity.Contact;
import com.example.contact.Exception.IncompleteDetailsException;
import com.example.contact.Exception.UserAlreadyExistException;
import com.example.contact.Exception.UserNotFoundException;
import com.example.contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    //test
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact createContact(Contact contact) {
        if(contact.getName().isEmpty() || contact.getPhoneNumber().isEmpty()){
            throw new IncompleteDetailsException("Enter complete details");
        }
        List<Contact> contacts= contactRepository.findByPhoneNumber(contact.getPhoneNumber());
        if(contacts.isEmpty()){
            return contactRepository.save(contact);
        }else{
            throw new UserAlreadyExistException("User already exist with phone number "+contact.getPhoneNumber());
        }

    }

    @Override
    public List<Contact> fetchAllContacts() {
        List<Contact> contactList= contactRepository.findAll();
        return contactList;
    }

    @Override
    public void deleteContact(Long id) {

    Contact contact= contactRepository.findById(id).orElseThrow(()-> new UserNotFoundException("user do not exist with id "+id));
        if (contact.getId() != null) {
            contactRepository.deleteById(id);
        }



    }
}
