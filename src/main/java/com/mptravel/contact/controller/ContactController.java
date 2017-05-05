package com.mptravel.contact.controller;

import com.mptravel.about.model.AboutBindingModel;
import com.mptravel.about.model.AboutViewModel;
import com.mptravel.contact.entity.Contact;
import com.mptravel.contact.model.ContactBindingModel;
import com.mptravel.contact.model.ContactViewModel;
import com.mptravel.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public String getContactPage(Model model) {
        ContactViewModel contactViewModel = this.contactService.getContacts();
        model.addAttribute("contacts", contactViewModel);

        return "contacts";
    }

    @GetMapping("/contacts/edit/{id}")
    public String getAboutPage(@PathVariable("id") long id, Model model) {
        ContactViewModel contactViewModel = this.contactService.getContactsById(id);

        model.addAttribute("contacts", contactViewModel);

        return "edit-contacts";
    }

    @PostMapping("contacts/edit/{id}")
    public String editAbout(@PathVariable("id") long id, @Valid @ModelAttribute ContactBindingModel contactBindingModel) {
        contactBindingModel.setId(id);
        this.contactService.updateContacts(contactBindingModel);

        return "redirect:/contacts";
    }

    //    TODO: Sample with Google Maps
    @GetMapping("/contacts/map")
    public String getAboutMapPage(Model model) {
        String geoJson = "{\n" +
                "  \"type\": \"FeatureCollection\",\n" +
                "  \"features\": [\n" +
                "    {\n" +
                "      \"type\": \"Feature\",\n" +
                "      \"geometry\": {\n" +
                "        \"type\": \"Point\",\n" +
                "        \"coordinates\": [\n" +
                "          23.352284118500393,\n" +
                "          42.666746158374856\n" +
                "        ]\n" +
                "      },\n" +
                "      \"properties\": {}\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        model.addAttribute("geoJson", geoJson);

        return "map";
    }
}
