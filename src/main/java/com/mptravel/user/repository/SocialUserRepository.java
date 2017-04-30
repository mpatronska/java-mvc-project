package com.mptravel.user.repository;

import com.mptravel.user.entity.SocialUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialUserRepository extends  UserRepository<SocialUser> {
}
