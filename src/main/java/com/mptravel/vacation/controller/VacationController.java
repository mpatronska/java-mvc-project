package com.mptravel.vacation.controller;

import com.mptravel.vacation.model.VacationBindingModel;
import com.mptravel.vacation.model.VacationViewModel;
import com.mptravel.vacation.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class VacationController {

    @Autowired
    private VacationService vacationService;

    @GetMapping("/vacations")
    public String /*ResponseEntity<List<VacationViewModel>>*/ getVacationsPage(Model model) {
        List<VacationViewModel> vacations = this.vacationService.getVacations();
        model.addAttribute("vacations", vacations);

        for (VacationViewModel vacation : vacations) {
            System.out.print(vacation.getImageUrl());
        }

        return "vacations";
//        return new ResponseEntity<List<VacationViewModel>>(vacations, HttpStatus.OK);
    }

    @GetMapping("/vacations/add")
    public String getAddVacationPage() {
        return "add-vacation";
    }

    @PostMapping("/vacations/add")
    public String addVacation(VacationBindingModel vacationBindingModel) {
        this.vacationService.addVacation(vacationBindingModel);

        return "redirect:/vacations";
    }

    @GetMapping("/vacations/details")
    public String getVacationDetailsPage(@RequestParam("id") long id, Model model) {
        VacationViewModel vacationViewModel = this.vacationService.findVacationById(id);
        model.addAttribute("vacation", vacationViewModel);

        return "vacation-details";
    }

    @GetMapping("vacations/edit/{id}")
    public String getEditVacationPage(@PathVariable("id") long id, Model model) {
        VacationViewModel vacationViewModel = this.vacationService.findVacationById(id);
        model.addAttribute("vacation", vacationViewModel);

        return "edit-vacation";
    }

    @PostMapping("vacations/edit/{id}")
    public String editVacation(@PathVariable("id") long id, VacationBindingModel vacationBindingModel) {
        vacationBindingModel.setId(id);
        this.vacationService.updateVacation(vacationBindingModel);

        return "redirect:/vacations";
    }

    @GetMapping("vacations/delete/{id}")
    public String getDeleteVacationPage(@PathVariable("id") long id, Model model) {
        VacationViewModel vacationViewModel = this.vacationService.findVacationById(id);
        model.addAttribute("vacation", vacationViewModel);

        return "delete-vacation";
    }

    @PostMapping("vacations/delete/{id}")
    public String deleteVacation(@PathVariable("id") long id) {
        this.vacationService.deleteVacationById(id);

        return "redirect:/vacations";
    }
}
