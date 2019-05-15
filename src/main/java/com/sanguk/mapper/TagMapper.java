package com.sanguk.mapper;

import java.util.List;

import com.sanguk.domain.TagVO;

import org.apache.ibatis.annotations.Mapper;

/**
 * Mybatis Tag Mapper 연결 인터페이스 입니다.
 * 
 * @author Sanguk
 * @version 1.0.0
 */
@Mapper
public interface TagMapper {

    /**
     * 
     * @param TagVO
     */
    void registerTag(TagVO TagVO);

    /**
     * 
     * @param articleid
     */
    void deleteTag(int articleid);

    /**
     * 
     * @param id
     * @return List<TagVO>
     */
    List<TagVO> getTagListById(int id);

    /**
     * 
     * @return List<TagVO>
     */
    List<TagVO> getTagRankedList();

}
