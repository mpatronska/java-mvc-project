package com.mptravel.vacation.service;

import com.mptravel.vacation.model.VacationBindingModel;
import com.mptravel.vacation.model.VacationViewModel;

import java.util.List;

public interface VacationService {

    List<VacationViewModel> getVacations();

    void addVacation(VacationBindingModel vacationBindingModel);

    VacationViewModel findVacationById(long id);

    void updateVacation(VacationBindingModel vacationBindingModel);

    void deleteVacationById(long id);
}
