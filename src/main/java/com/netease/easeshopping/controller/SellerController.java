package com.netease.easeshopping.controller;

import com.alibaba.fastjson.JSONObject;
import com.netease.easeshopping.model.Commodity;
import com.netease.easeshopping.service.CommodityService;
import com.netease.easeshopping.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 这里实现卖家的相关业务处理
 */
@Controller
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private CommodityService commodityService;

    /**
     * @return 进入到发布页面
     */
    @PreAuthorize("hasAuthority('SELLER')")
    @RequestMapping(path={"/public"}, method = {RequestMethod.GET,RequestMethod.POST})
    public String publish(HttpSession session){
        session.setAttribute("commodity", null);
        return "publish/public";
    }

    /**
     * @param session
     * @param title
     * @param summary
     * @param image
     * @param detail
     * @param price
     * @return 返回到发布状态页面
     * 实现第一次发布和对发布的商品再次进行修改
     */
    @PreAuthorize("hasAuthority('SELLER')")
    @RequestMapping(path={"/publicSubmit"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String submit(HttpSession session, @RequestParam("title") String title,
                         @RequestParam("summary") String summary, @RequestParam("image") String image,
                         @RequestParam("detail") String detail, @RequestParam("price") String price){
        try {
            Commodity commodity = (Commodity) session.getAttribute("commodity");
            if(commodity == null) { //第一次发布，新商品直接添加到数据库
                commodity = sellerService.submit(title, summary, image, detail, price);
            }else{//修改之前的商品信息
                //commodity = commodityService.getCommodityDetailByPrimaryKey(commodity.getId());
                commodity = sellerService.edit(commodity, title, summary, image, detail, price);
            }
            session.setAttribute("commodity", commodity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "publish/status";
    }

    /**
     * @param file
     * 用于接收上传的图片，并存储在本地磁盘
     */
    @PreAuthorize("hasAuthority('SELLER')")
    @RequestMapping(path={"/api/upload"}, method = {RequestMethod.POST})
    @ResponseBody
    public JSONObject upload(@RequestParam("file") MultipartFile file){
        String fileName = commodityService.saveImage(file);
        JSONObject json = new JSONObject();
        json.put("result", fileName);
        return json;
    }

    /**
     * @param session
     * @param id 商品id
     * @return 返回到发布页面
     * 将当前商品的信息传递到session域
     */
    @PreAuthorize("hasAuthority('SELLER')")
    @RequestMapping(path={"/edit"}, method = {RequestMethod.GET})
    public String edit(HttpSession session, @RequestParam("id") int id) {
        Commodity commodity = commodityService.getCommodityDetailByPrimaryKey(id);
        session.setAttribute("commodity", commodity);
        return "publish/public";
    }

    /**
     * @param model
     * @param id
     * @param response
     * @return 返回删除后的json消息
     * 当删除未购买的商品时，如果含有本地上传的图片，要删除图片和数据库记录
     */
    @PreAuthorize("hasAuthority('SELLER')")
    @RequestMapping(path={"/api/delete"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public JSONObject delete(Model model, @RequestParam("id") int id, HttpServletResponse response) {
        Commodity commodity = commodityService.getCommodityDetailByPrimaryKey(id);
        //删除本地图片
//        String url = commodity.getPicture();
//        int location = url.lastIndexOf(".");
//        if(location > 0 ){
//            String fileExt = url.substring(location + 1).toLowerCase();
//            if(BaseUtil.isFileAllowed(fileExt)) {
//                File file = new File(BaseUtil.IMAGE_DIR + url);
//                if (file.exists() && file.isFile()) {
//                    file.delete();
//                }
//            }
//        }
        commodityService.deleteCommodityByPrimaryKey(id);

        JSONObject json = new JSONObject();
        json.put("code", 200);
        json.put("result", "success");
        json.put("message", "delete ok");
        return json;
    }
}
