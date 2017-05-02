package com.mptravel.reservation.serviceimpl;

import com.mptravel.reservation.entity.Reservation;
import com.mptravel.reservation.model.ReservationBindingModel;
import com.mptravel.reservation.model.ReservationViewModel;
import com.mptravel.reservation.repository.ReservationRepository;
import com.mptravel.reservation.service.ReservationService;
import com.mptravel.user.entity.User;
import com.mptravel.vacation.entity.Vacation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRespository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ReservationViewModel> getReservationsByUser(User user) {
        long id = user.getId();
        List<Reservation> reservations = this.reservationRespository.findReservationsByUser(id);

        List<ReservationViewModel> reservationViewModels = new ArrayList<>();

        for (Reservation reservation : reservations) {
            ReservationViewModel reservationViewModel = this.modelMapper.map(reservation, ReservationViewModel.class);
            reservationViewModel.setVacations(reservation.getVacations());
            reservationViewModels.add(reservationViewModel);
        }

        return reservationViewModels;
    }

    @Override
    public void addReservation(ReservationBindingModel reservationBindingModel) {
        Reservation reservation = this.modelMapper.map(reservationBindingModel, Reservation.class);
        Set<User> users = new HashSet<>();
        users.add(reservationBindingModel.getUser());
        Set<Vacation> vacations = new HashSet<>();
        vacations.add(reservationBindingModel.getVacation());
        reservation.setUsers(users);
        reservation.setVacations(vacations);
        this.reservationRespository.save(reservation);
    }
}
