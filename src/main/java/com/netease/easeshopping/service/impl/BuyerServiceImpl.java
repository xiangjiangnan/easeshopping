package com.netease.easeshopping.service.impl;

import com.netease.easeshopping.dao.AccountMapper;
import com.netease.easeshopping.dao.CartMapper;
import com.netease.easeshopping.model.*;
import com.netease.easeshopping.service.BuyerService;
import com.netease.easeshopping.utils.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private CartMapper cartMapper;

    @Override
    public AccountWrapper getAccountByCid(String cid){
        HashMap<String, Object> map = null;
        AccountWrapper wrapper = new AccountWrapper();
        List<Account> accounts = accountMapper.selectByCid(cid);
        int totalNum = 0;
        if(accounts.size() > 0) {
            map = new HashMap<>(2);
            for (Account account : accounts) {
                totalNum += account.getQuantity();
            }
            wrapper.setCode(CodeUtil.SUCCESS.getCode());
            wrapper.setResult(CodeUtil.SUCCESS.getResult());
            wrapper.setMessage("获取成功。");
            wrapper.setPrice(accounts.get(0).getPrice());
            wrapper.setTotalNum(totalNum);
        }else{
            wrapper.setCode(CodeUtil.FAILED.getCode());
            wrapper.setResult(CodeUtil.FAILED.getResult());
            wrapper.setMessage("获取失败。");
        }
        return wrapper;
    }

    @Override
    public List<Account> getAllAccounts(){
        return accountMapper.selectAll();
    }

    @Override
    public void addAccount(Commodity commodity, int num){
        Account account = new Account();
        account.setCid(commodity.getCid());
        account.setTitle(commodity.getTitle());
        account.setPicture(commodity.getPicture());
        account.setPrice(commodity.getPrice());
        account.setQuantity(num);
        accountMapper.insert(account);
    }

    @Override
    public void editAccount(Account account){
        accountMapper.updateByPrimaryKey(account);
    }

    @Override
    public List<Cart> getAllCartAccounts(){
        return cartMapper.selectAll();
    }
}
