package com.netease.easeshopping.contrloller;


import com.netease.easeshopping.model.Commodity;
import com.netease.easeshopping.service.BuyerService;
import com.netease.easeshopping.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private BuyerService buyerService;

    /**
     * @param model
     * @return 进入到首页
     * 所有商品的展示
     */
    @RequestMapping(path={"/"}, method = {RequestMethod.GET})
    public String index(Model model){
        List<Commodity> list = commodityService.getAllCommodities();
        model.addAttribute("list", list);
        return "index";
    }

    /**
     * @param model
     * @return 进入到首页
     * 未购买商品的展示
     */
    @RequestMapping(path={"/"}, params = {"type"}, method = {RequestMethod.GET})
    public String index(Model model, @RequestParam("type") int type){
        List<Commodity> list = commodityService.getAllCommoditiesByStatus(0);
        model.addAttribute("list", list);
        model.addAttribute("type", 1);
        return "index";
    }

    /**
     * @param model
     * @param id
     * @return 进入到商品详情页面
     * 主要实现对商品详细信息的展示
     */
    @RequestMapping(path={"/show"}, method = {RequestMethod.GET})
    public String showDetail(Model model, @RequestParam("id") int id){
        Commodity commodity = commodityService.getCommodityDetailByPrimaryKey(id);
        model.addAttribute("commodity", commodity);
        Map<String, Object> map = buyerService.getAccountByCid(commodity.getCid());
        if(map != null) {
            model.addAttribute("price", map.get("price"));
            model.addAttribute("totalNum", map.get("totalNum"));
        }
        return "publish/detail";
    }

}
