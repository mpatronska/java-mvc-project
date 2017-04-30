package com.mptravel.vacation.serviceimpl;

import com.mptravel.vacation.entity.Vacation;
import com.mptravel.vacation.model.VacationBindingModel;
import com.mptravel.vacation.model.VacationViewModel;
import com.mptravel.vacation.repository.VacationRepository;
import com.mptravel.vacation.service.VacationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VacationServiceImpl implements VacationService {

    @Autowired
    private VacationRepository vacationRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<VacationViewModel> getVacations() {
        List<Vacation> vacations = this.vacationRepository.findAllVacations();

        List<VacationViewModel> vacationViewModels = new ArrayList<>();

        for (Vacation vacation : vacations) {
            VacationViewModel vacationViewModel = this.modelMapper.map(vacation, VacationViewModel.class);
            vacationViewModels.add(vacationViewModel);
        }

        return vacationViewModels;
    }

    @Override
    public void addVacation(VacationBindingModel vacationBindingModel) {
        Vacation vacation = this.modelMapper.map(vacationBindingModel, Vacation.class);

        this.vacationRepository.save(vacation);
    }

    @Override
    public VacationViewModel findVacationById(long id) {
        Vacation vacation = this.vacationRepository.findVacationById(id);

        VacationViewModel vacationViewModel = this.modelMapper.map(vacation, VacationViewModel.class);

        return vacationViewModel;
    }

    @Override
    public void updateVacation(VacationBindingModel vacationBindingModel) {
        Vacation vacation = this.modelMapper.map(vacationBindingModel, Vacation.class);

        this.vacationRepository.save(vacation);
    }

    @Override
    public void deleteVacationById(long id) {
        this.vacationRepository.delete(id);
    }
}
