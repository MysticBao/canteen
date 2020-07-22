package com.canteen.admin.repository;

import com.canteen.admin.model.AdminAccountDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminAccountRepository extends JpaRepository<AdminAccountDO, Long> {
    AdminAccountDO findByName(String name);
}
