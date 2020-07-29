package com.canteen.admin.service.impl;

import com.canteen.admin.model.AdminUser;
import com.canteen.admin.repository.AdminUserRepository;
import com.canteen.admin.service.AdminUserService;
import com.canteen.common.exception.CanteenServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserRepository adminUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AdminUser register(AdminUser adminUser) throws CanteenServiceException {
        AdminUser checkUser = adminUserRepository.findByName(adminUser.getName());
        // username is unique
        if (checkUser != null) {
            return null;
        }
        // encode password
        adminUser.setPassword(passwordEncoder.encode(adminUser.getPassword()));
        return adminUserRepository.save(adminUser);
    }

    @Override
    public String login(String username, String password) throws CanteenServiceException {
        AdminUser adminUser = adminUserRepository.findByName(username);
        if (!passwordEncoder.matches(password, adminUser.getPassword())) {
            throw new CanteenServiceException("Incorrect password!");
        }
        //TODO parse user login token
        updateLastLoginTime(adminUser);
        return null;
    }

    private void updateLastLoginTime(AdminUser adminUser){
        adminUser.setLastLoginTime(new Date());
        adminUserRepository.save(adminUser);
    }

    @Override
    public AdminUser update(AdminUser adminUser) throws CanteenServiceException {
        return adminUserRepository.save(adminUser);
    }


}
