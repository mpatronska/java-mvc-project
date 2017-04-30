package com.mptravel.contact.service;

import com.mptravel.contact.model.ContactBindingModel;
import com.mptravel.contact.model.ContactViewModel;

public interface ContactService {

    ContactViewModel getContacts();

    ContactViewModel getContactsById(long id);

    void updateContacts(ContactBindingModel contactBindingModel);
}
