package com.netease.easeshopping.service;

import com.netease.easeshopping.model.Account;
import com.netease.easeshopping.model.Cart;
import com.netease.easeshopping.model.Commodity;

import java.util.List;
import java.util.Map;

public interface BuyerService {
    Map<String, Object> getAccountByCid(String cid);
    List<Account> getAllAccounts();
    void addAccount(Commodity commodity, int num);
    void editAccount(Account account);
    List<Cart> getAllCartAccounts();
}
