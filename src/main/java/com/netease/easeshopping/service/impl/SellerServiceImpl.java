package com.netease.easeshopping.service.impl;

import com.netease.easeshopping.dao.CommodityMapper;
import com.netease.easeshopping.dao.UuidMapper;
import com.netease.easeshopping.model.Commodity;
import com.netease.easeshopping.service.CommodityService;
import com.netease.easeshopping.service.SellerService;
import com.netease.easeshopping.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private CommodityMapper commodityMapper;

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private UuidMapper uuidMapper;

    @Override
    public Commodity submit(String title, String summary, String image, String detail,
                            String price){
        Commodity commodity = new Commodity();
        String cid = new UuidUtil(uuidMapper).generate();//生成商品唯一id
        commodity.setCid(cid);
        commodity.setTitle(title);
        commodity.setRemark(summary);
        commodity.setContent(detail);
        commodity.setPrice(Float.valueOf(price));
        if(image != null && image.length() > 0){//保存图片网址
            commodity.setPicture(image);
        }else{//保存图片本地地址
            commodity.setPicture(commodityService.getfileName());
        }
        commodityService.addNewCommodity(commodity);
        return commodityService.getCommodityByCid(cid);
    }

    @Override
    public Commodity edit(Commodity commodity, String title, String summary, String image,
                          String detail, String price){
        return commodityService.updateCommodityById(commodity, title, summary, image, detail, price);
    }

}
