package com.canteen.admin;

import com.canteen.admin.model.AdminUser;
import com.canteen.admin.model.Shop;
import com.canteen.admin.model.ShopStatusEnum;
import com.canteen.admin.repository.AdminUserRepository;
import com.canteen.admin.repository.ShopRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories
@Slf4j
public class AdminApplication implements ApplicationRunner {
    @Autowired
    private AdminUserRepository adminAccountRepository;
    @Autowired
    private ShopRepository shopRepository;

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        AdminUser admin = AdminUser.builder().name("admin").password("123").build();
        admin = adminAccountRepository.save(admin);
        log.info("Add Admin" + admin);
        List<AdminUser> admins = adminAccountRepository.findAll();
        log.info("List admins: ");
        for (AdminUser adminAccountDO : admins) {
            log.info(adminAccountDO.toString());
            adminAccountDO.setPassword("new123");
            admin = adminAccountRepository.save(adminAccountDO);
            log.info("Update admin password: " + admin);
        }
        admin = adminAccountRepository.findByName("admin");
        log.info(admin.toString());

        Shop shopDO = Shop.builder().name("shop1").expiration(new Date()).status(ShopStatusEnum.ALIVE).build();
        shopDO = shopRepository.save(shopDO);
        log.info("Add shop count: " + shopDO);
        List<Shop> shopDOS = shopRepository.findAll();
        for (Shop shop : shopDOS) {
            log.info(shop.toString());
            shop.setStatus(ShopStatusEnum.OVERDUE);
            shopDO = shopRepository.save(shop);
            log.info("Update Shop status: " + shopDO);
        }
        Optional<Shop> shop = shopRepository.findById(shopDO.getId());
        log.info(shop.get().toString());

        shopDOS = shopRepository.findAll();
        log.info("Size: " + shopDOS.size());

        shopDOS = shopRepository.findAll(Sort.by("status"));
        log.info("Alive Size: " + shopDOS.size());

    }
}
