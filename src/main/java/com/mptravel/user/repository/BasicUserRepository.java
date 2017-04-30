package com.mptravel.user.repository;

import com.mptravel.user.entity.BasicUser;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicUserRepository extends UserRepository<BasicUser> {
}
