package com.mptravel.reservation.controller;

import com.mptravel.reservation.model.ReservationBindingModel;
import com.mptravel.reservation.model.ReservationViewModel;
import com.mptravel.reservation.service.ReservationService;
import com.mptravel.user.entity.User;
import com.mptravel.vacation.entity.Vacation;
import com.mptravel.vacation.model.VacationViewModel;
import com.mptravel.vacation.service.VacationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ReservationController {

    private ReservationService reservationService;
    private VacationService vacationService;
    private ModelMapper modelMapper;

    @Autowired
    ReservationController(ReservationService reservationService, VacationService vacationService, ModelMapper modelMapper) {
        this.reservationService = reservationService;
        this.vacationService = vacationService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/reservations")
    public String getReservationsPage(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<ReservationViewModel> reservationViewModels = this.reservationService.getReservationsByUser(user);

        model.addAttribute("reservations", reservationViewModels);

        return "reservations";
    }

    @GetMapping("reservations/add")
    public String getAddReservationPage(@RequestParam("id") long id, Model model, @ModelAttribute ReservationBindingModel reservationBindingModel) {
        VacationViewModel vacationViewModel = this.vacationService.findVacationById(id);

        System.out.print("vacation: " + vacationViewModel + ", title: " + vacationViewModel.getTitle());
        model.addAttribute("vacation", vacationViewModel);

        return "add-reservation";
    }

    @PostMapping("reservations/add")
    public String addReservation(@RequestParam("id") long id, Model model, @Valid @ModelAttribute ReservationBindingModel reservationBindingModel,
                                 BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            VacationViewModel vacationViewModel = this.vacationService.findVacationById(id);
            model.addAttribute("vacation", vacationViewModel);
            return "add-reservation";
        }

        VacationViewModel vacationViewModel = this.vacationService.findVacationById(id);
        Vacation vacation = this.modelMapper.map(vacationViewModel, Vacation.class);
        reservationBindingModel.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        reservationBindingModel.setVacation(vacation);
        this.reservationService.addReservation(reservationBindingModel);

        return "redirect:/reservations";
    }



}
