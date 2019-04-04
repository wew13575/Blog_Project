package com.sanguk.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

 @Select("SELECT * from users")
 public String getTime();

 public void selectlist();
}
