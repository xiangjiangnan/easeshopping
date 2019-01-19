package com.netease.easeshopping.dao;

import com.netease.easeshopping.model.Commodity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommodityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Commodity record);

    int insertSelective(Commodity record);

    Commodity selectByPrimaryKey(Integer id);

    Commodity selectByCid(String cid);

    List<Commodity> selectAll();

    List<Commodity> selectAllByStatus(int isSelled);

    int updateByPrimaryKeySelective(Commodity record);

    int updateByPrimaryKey(Commodity record);
}