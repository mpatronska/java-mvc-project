package com.mptravel.about.serviceimpl;

import com.mptravel.about.entity.About;
import com.mptravel.about.model.AboutBindingModel;
import com.mptravel.about.model.AboutViewModel;
import com.mptravel.about.repository.AboutRepository;
import com.mptravel.about.service.AboutService;
import com.mptravel.trip.entity.Trip;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AboutServiceImpl implements AboutService {

    @Autowired
    private AboutRepository aboutRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AboutViewModel> getAbout() {
        List<About> abouts = this.aboutRepository.findAbout();

        List<AboutViewModel> aboutViewModels = new ArrayList<>();
        for (About about : abouts) {
            AboutViewModel aboutViewModel = this.modelMapper.map(about, AboutViewModel.class);
            aboutViewModels.add(aboutViewModel);
        }

        return aboutViewModels;
    }

    @Override
    public AboutViewModel getAboutById(long id) {
        About about = this.aboutRepository.findAboutById(id);
        AboutViewModel aboutViewModel = this.modelMapper.map(about, AboutViewModel.class);
        return aboutViewModel;
    }

    @Override
    public void updateAbout(AboutBindingModel aboutBindingModel) {
        About about = this.modelMapper.map(aboutBindingModel, About.class);

        this.aboutRepository.save(about);
    }
}
