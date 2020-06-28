package com.canteen.stall.mapper;

import com.canteen.stall.model.Stall;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StallMapper {
    @Insert("insert into stall(name,label,description,create_time,status) " +
            "values(#{name},#{label},#{description},now(),#{status})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int add(Stall stall);

    @Select("select * from stall where id=#{id}")
    Stall findById(@Param("id") Long id);

    @Select("select * from stall where name=#{name}")
    Stall findByName(@Param("name") String name);

    @Select("Select * from stall")
    List<Stall> findAll();
}
