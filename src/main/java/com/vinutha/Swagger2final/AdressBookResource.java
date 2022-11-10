package com.vinutha.Swagger2final;

import com.vinutha.Swagger2final.pojos.Contact;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/api")
public class AdressBookResource {

    ConcurrentMap<String,Contact> contacts = new ConcurrentHashMap<>();
    @GetMapping("/{id}")
    public Contact getContact(@PathVariable String id){
        return contacts.get(id);
    }
    @GetMapping("/")
    public List<Contact> getAllContacts(){
        return new ArrayList<Contact>(contacts.values());
    }
    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact){
        return contacts.put(contact.getId(),contact);
        //return contact;
    }

}
