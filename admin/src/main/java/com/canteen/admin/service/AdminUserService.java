package com.canteen.admin.service;

import com.canteen.admin.model.AdminUser;
import com.canteen.common.exception.CanteenServiceException;

public interface AdminUserService {
    /**
     * registering function
     *
     * @param adminUser
     * @return
     */
    AdminUser register(AdminUser adminUser) throws CanteenServiceException;

    String login(String username, String password) throws CanteenServiceException;

    /**
     * update admin information
     * @param adminUser
     * @return
     */
    AdminUser update(AdminUser adminUser) throws CanteenServiceException;

}
