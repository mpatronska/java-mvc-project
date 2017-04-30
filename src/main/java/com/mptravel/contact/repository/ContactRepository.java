package com.mptravel.contact.repository;

import com.mptravel.contact.entity.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {

    @Query("SELECT c FROM Contact AS c")
    List<Contact> findContacts();

    Contact findContactById(@Param("id") long id);
}
