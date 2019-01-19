package com.netease.easeshopping.service.impl;

import com.netease.easeshopping.dao.AccountMapper;
import com.netease.easeshopping.dao.CartMapper;
import com.netease.easeshopping.model.Account;
import com.netease.easeshopping.model.Cart;
import com.netease.easeshopping.model.Commodity;
import com.netease.easeshopping.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private CartMapper cartMapper;

    @Override
    public Map<String, Object> getAccountByCid(String cid){
        HashMap<String, Object> map = null;
        List<Account> accounts = accountMapper.selectByCid(cid);
        int totalNum = 0;
        if(accounts.size() > 0) {
            map = new HashMap<>(2);
            for (Account account : accounts) {
                totalNum += account.getQuantity();
            }
            map.put("price", accounts.get(0).getPrice());
            map.put("totalNum", totalNum);
        }
        return map;
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
