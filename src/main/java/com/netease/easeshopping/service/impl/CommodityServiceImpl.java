package com.netease.easeshopping.service.impl;

import com.netease.easeshopping.dao.CommodityMapper;
import com.netease.easeshopping.model.Commodity;
import com.netease.easeshopping.service.CommodityService;
import com.netease.easeshopping.utils.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
public class CommodityServiceImpl implements CommodityService {

    private String fileName;

    @Autowired
    private CommodityMapper commodityMapper;

    private void setfileName(String fileName){
        this.fileName = fileName;
    }

    @Override
    public String getfileName(){
        return fileName;
    }

    @Override
    public Commodity getCommodityDetailByPrimaryKey(int id){
        return commodityMapper.selectByPrimaryKey(id);
    }

    @Override
    public Commodity getCommodityDetailByCid(String cid){
        return commodityMapper.selectByCid(cid);
    }

    @Override
    public void updateCommodityStatus(Commodity commodity){
        commodity.setIsSelled(1);
        commodityMapper.updateByPrimaryKey(commodity);
    }

    @Override
    public Commodity updateCommodityById(Commodity commodity, String title, String summary,
                                    String image, String detail, String price){
        commodity.setTitle(title);
        commodity.setRemark(summary);
        commodity.setContent(detail);
        commodity.setPrice(Float.valueOf(price));
        if(image != null && image.length() > 0){
            commodity.setPicture(image);
        }
        commodityMapper.updateByPrimaryKey(commodity);
        return commodity;
    }

    @Override
    public void deleteCommodityByPrimaryKey(int id){
        int  flag = commodityMapper.deleteByPrimaryKey(id);
        System.out.println(flag);
    }
    @Override
    public List<Commodity> getAllCommodities(){
        return commodityMapper.selectAll();
    }

    @Override
    public List<Commodity> getAllCommoditiesByStatus(int type){
        return commodityMapper.selectAllByStatus(type);
    }

    @Override
    public String saveImage(MultipartFile file){
        int dotPos = file.getOriginalFilename().lastIndexOf(".");
        if (dotPos < 0) {
            return null;
        }
        String fileExt = file.getOriginalFilename().substring(dotPos + 1).toLowerCase();
        if (!BaseUtil.isFileAllowed(fileExt)) {
            return null;
        }
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + fileExt;
        try {
            Files.copy(file.getInputStream(), new File(BaseUtil.IMAGE_DIR + fileName).toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setfileName(fileName);//保存本地文件名
        return fileName;
    }

    @Override
    public int addNewCommodity(Commodity commodity){
        return commodityMapper.insert(commodity);
    }

    @Override
    public Commodity getCommodityByCid(String cid){
        return commodityMapper.selectByCid(cid);
    }
}
