package com.mptravel.user.service;

import org.springframework.social.facebook.api.User;

public interface SocialUserService {

    void registerOrLogin(User facebookUser);
}
