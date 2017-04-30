package com.mptravel.vacation.repository;

import com.mptravel.vacation.entity.Vacation;
import com.mptravel.vacation.model.VacationViewModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationRepository extends CrudRepository<Vacation, Long> {

    @Query("SELECT v FROM Vacation AS v")
    List<Vacation> findAllVacations();

    Vacation findVacationById(@Param("id") long id);
}
