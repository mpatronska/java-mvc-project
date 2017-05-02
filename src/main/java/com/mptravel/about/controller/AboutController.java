package com.mptravel.about.controller;

import com.mptravel.about.model.AboutBindingModel;
import com.mptravel.about.model.AboutViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.mptravel.about.service.AboutService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AboutController {

    @Autowired
    private AboutService aboutService;

    @GetMapping("/about")
    public String getAboutPage(Model model) {
        AboutViewModel aboutViewModel = this.aboutService.getAbout().get(0);

        model.addAttribute("about", aboutViewModel);

        return "about";
    }

    @GetMapping("/about/edit/{id}")
    public String getAboutPage(@PathVariable("id") long id, Model model) {
        AboutViewModel aboutViewModel = this.aboutService.getAboutById(id);

        System.out.print(aboutViewModel.getDescription());
        model.addAttribute("about", aboutViewModel);

        return "edit-about";
    }

    @PostMapping("about/edit/{id}")
    public String editAbout(@PathVariable("id") long id, @Valid @ModelAttribute AboutBindingModel aboutBindingModel) {
        aboutBindingModel.setId(id);
        this.aboutService.updateAbout(aboutBindingModel);

        return "redirect:/about";
    }
}
