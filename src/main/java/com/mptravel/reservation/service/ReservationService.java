package com.mptravel.reservation.service;


import com.mptravel.reservation.model.ReservationBindingModel;
import com.mptravel.reservation.model.ReservationViewModel;
import com.mptravel.user.entity.User;

import java.util.List;

public interface ReservationService {

    List<ReservationViewModel> getReservationsByUser(User user);

    void addReservation(ReservationBindingModel reservationBindingModel);
}
