package com.netease.easeshopping.service;

import com.netease.easeshopping.model.*;

import java.util.List;

public interface BuyerService {
    AccountWrapper getAccountByCid(String cid);
    List<Account> getAllAccounts();
    void addAccount(Commodity commodity, int num);
    void editAccount(Account account);
    List<Cart> getAllCartAccounts();
}
