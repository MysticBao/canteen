package com.canteen.stall.mapper.product;

import com.canteen.stall.model.Stall;
import com.canteen.stall.model.product.ProductBrand;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductBrandMapper {
    @Insert("insert into product_brand(name,label,description,create_time,last_update_time) " +
            "values(#{name},#{label},#{description},now(),now())")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int add(ProductBrand pBrand);

    @Select("select * from product_brand where id=#{id}")
    ProductBrand findById(@Param("id") Long id);

    @Select("select * from product_brand where name=#{name}")
    ProductBrand findByName(@Param("name") String name);

    @Select("Select * from product_brand")
    List<ProductBrand> findAll();
}
