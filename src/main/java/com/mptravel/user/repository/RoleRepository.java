package com.mptravel.user.repository;

import com.mptravel.user.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findOneByAuthority(String authority);
}
