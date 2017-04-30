package com.mptravel.reservation.serviceimpl;

import com.mptravel.reservation.entity.Reservation;
import com.mptravel.reservation.model.ReservationBindingModel;
import com.mptravel.reservation.model.ReservationViewModel;
import com.mptravel.reservation.repository.ReservationRepository;
import com.mptravel.reservation.service.ReservationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRespository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ReservationViewModel> getReservations() {
        List<Reservation> reservations = this.reservationRespository.findReservations();

        List<ReservationViewModel> reservationViewModels = new ArrayList<>();

        for (Reservation reservation : reservations) {
            ReservationViewModel reservationViewModel = this.modelMapper.map(reservation, ReservationViewModel.class);
            reservationViewModels.add(reservationViewModel);
        }

        return reservationViewModels;
    }

    @Override
    public void addReservation(ReservationBindingModel reservationBindingModel) {
        Reservation reservation = this.modelMapper.map(reservationBindingModel, Reservation.class);

        this.reservationRespository.save(reservation);
    }
}
