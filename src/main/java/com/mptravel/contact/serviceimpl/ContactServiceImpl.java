package com.mptravel.contact.serviceimpl;

import com.mptravel.contact.entity.Contact;
import com.mptravel.contact.model.ContactBindingModel;
import com.mptravel.contact.model.ContactViewModel;
import com.mptravel.contact.repository.ContactRepository;
import com.mptravel.contact.service.ContactService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ContactViewModel getContacts() {
        Contact contact = this.contactRepository.findContacts().get(0);
        ContactViewModel contactViewModel = this.modelMapper.map(contact, ContactViewModel.class);

        return contactViewModel;
    }

    @Override
    public ContactViewModel getContactsById(long id) {
        Contact contact = this.contactRepository.findContactById(id);
        ContactViewModel contactViewModel = this.modelMapper.map(contact, ContactViewModel.class);

        return contactViewModel;
    }

    @Override
    public void updateContacts(ContactBindingModel contactBindingModel) {
        Contact contact = this.modelMapper.map(contactBindingModel, Contact.class);

        this.contactRepository.save(contact);
    }
}
