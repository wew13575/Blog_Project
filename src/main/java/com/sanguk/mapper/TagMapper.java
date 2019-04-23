package com.sanguk.mapper;

import com.sanguk.domain.TagVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagMapper {

    void registerTag(TagVO TagVO);
    void deleteTag(int articleid);
}
