package com.sanguk.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

 @Select("SELECT * from users")
 public String getTime();

 public void selectlist();
}
