package com.netease.easeshopping.dao;

import com.netease.easeshopping.model.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    List<Account> selectByCid(String cid);

    List<Account> selectAll();

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}