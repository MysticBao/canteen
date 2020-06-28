package com.canteen.stall;

import com.canteen.stall.mapper.StallMapper;
import com.canteen.stall.mapper.product.ProductBrandMapper;
import com.canteen.stall.mapper.product.ProductCategoryMapper;
import com.canteen.stall.mapper.product.ProductInfoMapper;
import com.canteen.stall.model.Stall;
import com.canteen.stall.model.product.ProductBrand;
import com.canteen.stall.model.product.ProductCategory;
import com.canteen.stall.model.product.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Slf4j
public class StallApplication implements ApplicationRunner {

    @Autowired
    private StallMapper stallMapper;
    @Autowired
    private ProductBrandMapper brandMapper;
    @Autowired
    private ProductCategoryMapper categoryMapper;
    @Autowired
    private ProductInfoMapper productMapper;

    public static void main(String[] args) {
        SpringApplication.run(StallApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Stall stall = Stall.builder().name("Test1").label("测试1").status(0).description("SSSS")
                .build();
        int count = stallMapper.add(stall);
        log.info("Add {} Stall: {}", count, stall);

        stall = stallMapper.findById(stall.getId());
        log.info("Find Stall: {}", stall);

        stall = stallMapper.findByName(stall.getName());
        log.info("Find Stall: {}", stall);

        List<Stall> stalls = stallMapper.findAll();
        log.info("Find stall size: {}", stalls.size());

		log.info("======================================");

		ProductCategory category = ProductCategory.builder().name("C1").label("C_l1").build();
		count = categoryMapper.add(category);
		log.info("Add {} ProductCategory: {}", count, category);

		category = categoryMapper.findById(category.getId());
		log.info("Find ProductCategory: {}", category);

		category = categoryMapper.findByName(category.getName());
		log.info("Find ProductCategory: {}", category);

		List<ProductCategory> categorys = categoryMapper.findAll();
		log.info("Find ProductCategory size: {}", categorys.size());

		log.info("======================================");

		ProductBrand brand = ProductBrand.builder().name("B1").label("B_l1").description("B_D1").build();
		count = brandMapper.add(brand);
		log.info("Add {} ProductBrand: {}", count, brand);

		brand = brandMapper.findById(brand.getId());
		log.info("Find ProductBrand: {}", brand);

		brand = brandMapper.findByName(brand.getName());
		log.info("Find ProductBrand: {}", brand);

		List<ProductBrand> brands = brandMapper.findAll();
		log.info("Find ProductBrand size: {}", brands.size());
		log.info("======================================");

		ProductInfo product = ProductInfo.builder().name("P1").icon("P1ICON").description("P_D1")
				.price(Money.of(CurrencyUnit.of("CNY"), 20.0)).build();
		count = productMapper.add(product);

		log.info("Add {} ProductInfo: {}", count, product);

		product = productMapper.findById(brand.getId());
		log.info("Find ProductInfo: {}", product);

		product = productMapper.findByName(brand.getName());
		log.info("Find ProductInfo: {}", product);

		List<ProductInfo> products = productMapper.findAll();
		log.info("Find ProductInfo size: {}", products.size());
    }
}
