package com.mptravel.user.service;

import com.mptravel.user.model.RegistrationModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface BasicUserService extends UserDetailsService {

    void register(RegistrationModel registrationModel);
}