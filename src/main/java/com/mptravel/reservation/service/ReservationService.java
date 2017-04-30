package com.mptravel.reservation.service;


import com.mptravel.reservation.model.ReservationBindingModel;
import com.mptravel.reservation.model.ReservationViewModel;
import com.mptravel.vacation.entity.Vacation;

import java.util.List;

public interface ReservationService {

    List<ReservationViewModel> getReservations();

    void addReservation(ReservationBindingModel reservationBindingModel);
}
