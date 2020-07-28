package com.canteen.admin.repository;

import com.canteen.admin.model.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {
    AdminUser findByName(String name);
}
