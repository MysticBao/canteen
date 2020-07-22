package com.canteen.admin;

import com.canteen.admin.model.AdminAccountDO;
import com.canteen.admin.model.ShopDO;
import com.canteen.admin.model.ShopStatusEnum;
import com.canteen.admin.repository.AdminAccountRepository;
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

@SpringBootApplication
@EnableJpaRepositories
@Slf4j
public class AdminApplication implements ApplicationRunner {
    @Autowired
    private AdminAccountRepository adminAccountRepository;
    @Autowired
    private ShopRepository shopRepository;

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        AdminAccountDO admin = AdminAccountDO.builder().name("admin").password("123").build();
        admin = adminAccountRepository.save(admin);
        log.info("Add Admin" + admin);
        List<AdminAccountDO> admins = adminAccountRepository.findAll();
        log.info("List admins: ");
        for (AdminAccountDO adminAccountDO : admins) {
            log.info(adminAccountDO.toString());
            adminAccountDO.setPassword("new123");
            admin = adminAccountRepository.save(adminAccountDO);
            log.info("Update admin password: " + admin);
        }
        admin = adminAccountRepository.findByName("admin");
        log.info(admin.toString());

        ShopDO shopDO = ShopDO.builder().name("shop1").expiration(new Date()).status(ShopStatusEnum.ALIVE).build();
        shopDO = shopRepository.save(shopDO);
        log.info("Add shop count: " + shopDO);
        List<ShopDO> shopDOS = shopRepository.findAll();
        for (ShopDO shop : shopDOS) {
            log.info(shop.toString());
            shop.setStatus(ShopStatusEnum.OVERDUE);
            shopDO = shopRepository.save(shop);
            log.info("Update Shop status: " + shopDO);
        }
        shopDO = shopRepository.findById(shopDO.getId()).get();
        log.info(shopDO.toString());

        shopDOS = shopRepository.findAll();
        log.info("Size: " + shopDOS.size());

        shopDOS = shopRepository.findAll(Sort.by("status"));
        log.info("Alive Size: " + shopDOS.size());

    }
}
