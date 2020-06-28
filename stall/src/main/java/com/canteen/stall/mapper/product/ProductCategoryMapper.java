package com.canteen.stall.mapper.product;

import com.canteen.stall.model.Stall;
import com.canteen.stall.model.product.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductCategoryMapper {
    @Insert("insert into product_category(name,label,create_time,last_update_time) " +
            "values(#{name},#{label},now(),now())")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int add(ProductCategory pCategory);

    @Select("select * from product_category where id=#{id}")
    ProductCategory findById(@Param("id") Long id);

    @Select("select * from product_category where name=#{name}")
    ProductCategory findByName(@Param("name") String name);

    @Select("Select * from product_category")
    List<ProductCategory> findAll();
}
