package com.netease.easeshopping.service;

import com.netease.easeshopping.model.Commodity;

public interface SellerService {
    Commodity submit(String title, String summary, String image, String detail, String price);
    Commodity edit(Commodity commodity, String title, String summary, String image, String detail, String price);
}
