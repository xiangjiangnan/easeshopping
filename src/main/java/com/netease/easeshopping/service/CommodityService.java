package com.netease.easeshopping.service;

import com.netease.easeshopping.model.Commodity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CommodityService {
    Commodity getCommodityDetailByCid(String cid);
    Commodity getCommodityDetailByPrimaryKey(int id);
    Commodity updateCommodityById(Commodity commodity, String title, String summary,
                                  String image, String detail, String price);
    void deleteCommodityByPrimaryKey(int id);
    List<Commodity> getAllCommodities();
    List<Commodity> getAllCommoditiesByStatus(int type);
    void updateCommodityStatusAndNum(Commodity commodity, int num);
    String saveImage(MultipartFile file);
    int addNewCommodity(Commodity commodity);
    Commodity getCommodityByCid(String cid);
    String getfileName();

}
