package com.mptravel.reservation.repository;

import com.mptravel.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation AS r JOIN r.users AS u JOIN r.vacations WHERE u.id = :id ")
    List<Reservation> findReservationsByUser(@Param("id") long id);
}
