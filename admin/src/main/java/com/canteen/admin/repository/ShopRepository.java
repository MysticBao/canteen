package com.canteen.admin.repository;

import com.canteen.admin.model.ShopDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<ShopDO,Long> {
}
