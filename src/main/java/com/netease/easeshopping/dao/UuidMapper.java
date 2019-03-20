package com.netease.easeshopping.dao;

import com.netease.easeshopping.model.Uuid;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UuidMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Uuid record);

    int insertSelective(Uuid record);

    Uuid selectByPrimaryKey(Integer id);

    Uuid selectByUuid(String uuid);

    long getTotalCount();

    int updateByPrimaryKeySelective(Uuid record);

    int updateByPrimaryKey(Uuid record);
}