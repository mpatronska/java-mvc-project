package com.mptravel.about.service;

import com.mptravel.about.model.AboutBindingModel;
import com.mptravel.about.model.AboutViewModel;

import java.util.List;

public interface AboutService {

    List<AboutViewModel> getAbout();

    AboutViewModel getAboutById(long id);

    void updateAbout(AboutBindingModel aboutBindingModel);
}
