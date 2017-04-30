package com.mptravel.user.serviceimpl;

import com.mptravel.user.entity.Role;
import com.mptravel.user.repository.RoleRepository;
import com.mptravel.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    public static final String DEFAULT_ROLE = "ROLE_USER";

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getDefaultRole() {
        return this.roleRepository.findOneByAuthority(DEFAULT_ROLE);
    }
}
