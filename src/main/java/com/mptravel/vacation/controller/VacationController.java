package com.mptravel.vacation.controller;

import com.mptravel.reservation.service.ReservationService;
import com.mptravel.vacation.model.VacationBindingModel;
import com.mptravel.vacation.model.VacationViewModel;
import com.mptravel.vacation.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class VacationController {

    private VacationService vacationService;
    private ReservationService reservationService;

    @Autowired
    public VacationController(VacationService vacationService, ReservationService reservationService) {
        this.vacationService = vacationService;
        this.reservationService = reservationService;
    }


    //    TODO: Sample with AJAX
//    @GetMapping("/vacations")
//    public ResponseEntity<List<VacationViewModel>> getVacationsPage() {
//        List<VacationViewModel> vacations = this.vacationService.getVacations();
//
//        if (null == vacations) {
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity(vacations, HttpStatus.OK);
//    }

    @GetMapping("/vacations")
    public String getVacationsPage(Model model) {
        List<VacationViewModel> vacations = this.vacationService.getVacations();
        model.addAttribute("vacations", vacations);

//        for (VacationViewModel vacation : vacations) {
//            System.out.print(vacation.getImageUrl());
//        }

        return "vacations";
    }

    @GetMapping("/vacations/add")
    public String getAddVacationPage(@ModelAttribute VacationBindingModel vacationBindingModel) {
        return "add-vacation";
    }

    @PostMapping("/vacations/add")
    public String addVacation(@Valid @ModelAttribute VacationBindingModel vacationBindingModel, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            System.out.print(bindingResult.getAllErrors());
            return "add-vacation";
        }
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
    public String getEditVacationPage(@PathVariable("id") long id, Model model, @ModelAttribute VacationBindingModel vacationBindingModel) {
        VacationViewModel vacationViewModel = this.vacationService.findVacationById(id);
        model.addAttribute("vacation", vacationViewModel);

        return "edit-vacation";
    }

    @PostMapping("vacations/edit/{id}")
    public String editVacation(@PathVariable("id") long id, Model model, @Valid @ModelAttribute VacationBindingModel vacationBindingModel,
                               BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            VacationViewModel vacationViewModel = this.vacationService.findVacationById(id);
            model.addAttribute("vacation", vacationViewModel);
            return "edit-vacation";
        }

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
        this.reservationService.deleteReservationByVacationId(id);
        this.vacationService.deleteVacationById(id);

        return "redirect:/vacations";
    }
}
