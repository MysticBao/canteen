package com.canteen.stall.mapper.product;

import com.canteen.stall.model.Stall;
import com.canteen.stall.model.product.ProductInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductInfoMapper {
    @Insert("insert into product_info(name,icon,status,description,price,category_id,brand_id,create_time,last_update_time) " +
            "values(#{name},#{icon},#{status},#{description},#{price},#{category_id},#{brand_id},now(),now())")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int add(ProductInfo pInfo);

    @Select("select * from product_info where id=#{id}")
    ProductInfo findById(@Param("id") Long id);

    @Select("select * from product_info where name=#{name}")
    ProductInfo findByName(@Param("name") String name);

    @Select("Select * from product_info")
    List<ProductInfo> findAll();
}
