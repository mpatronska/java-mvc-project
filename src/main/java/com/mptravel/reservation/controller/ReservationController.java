package com.mptravel.reservation.controller;

import com.mptravel.reservation.entity.Reservation;
import com.mptravel.reservation.model.ReservationBindingModel;
import com.mptravel.reservation.model.ReservationViewModel;
import com.mptravel.reservation.service.ReservationService;
import com.mptravel.vacation.entity.Vacation;
import com.mptravel.vacation.model.VacationBindingModel;
import com.mptravel.vacation.model.VacationViewModel;
import com.mptravel.vacation.service.VacationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private VacationService vacationService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/reservations")
    public String getReservationsPage(Model model) {
        List<ReservationViewModel> reservationViewModels = this.reservationService.getReservations();

        model.addAttribute("reservations", reservationViewModels);

        return "reservations";
    }

    @GetMapping("reservations/add")
    public String getAddReservationPage(@RequestParam("id") long id, Model model) {
        VacationViewModel vacationViewModel = this.vacationService.findVacationById(id);

        model.addAttribute("vacation", vacationViewModel);

        return "add-reservation";
    }

    @PostMapping("reservations/add")
    public String addReservation(@RequestParam("id") long id, ReservationBindingModel reservationBindingModel) {
        VacationViewModel vacationViewModel = this.vacationService.findVacationById(id);
        Vacation vacation = this.modelMapper.map(vacationViewModel, Vacation.class);
        reservationBindingModel.setVacation(vacation);
        this.reservationService.addReservation(reservationBindingModel);

        return "redirect:/reservations";
    }



}
