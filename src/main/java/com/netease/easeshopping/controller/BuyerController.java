package com.netease.easeshopping.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.netease.easeshopping.model.Account;
import com.netease.easeshopping.model.Cart;
import com.netease.easeshopping.model.Commodity;
import com.netease.easeshopping.service.BuyerService;
import com.netease.easeshopping.service.CommodityService;
import com.netease.easeshopping.utils.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BuyerController {

    @Autowired
    BuyerService buyerService;

    @Autowired
    CommodityService commodityService;
    /**
     * @param model
     * @return 进入到首页
     * 已购买商品的展示
     */
    @PreAuthorize("hasAuthority('BUYER')")
    @RequestMapping(path = {"/account"}, method = {RequestMethod.GET})
    public String account(Model model){
        float total = 0;
        List<Commodity> commodities = new ArrayList<>();
        List<Account> list = buyerService.getAllAccounts();
        model.addAttribute("list", list);
        for(Account account : list){
            Commodity commodity = commodityService.getCommodityByCid(account.getCid());
            account.setId(commodity.getId());
            total += account.getPrice() * account.getQuantity();
        }
        model.addAttribute("total" , total);
        return "account/account";
    }

    /**
     * @param model
     * @return 进入购物车
     * 购物车商品展示
     */
    @PreAuthorize("hasAuthority('BUYER')")
    @RequestMapping(path = {"/settleAccount"}, method = {RequestMethod.GET})
    public String selectAccount(Model model){
        List<Cart> list = buyerService.getAllCartAccounts();
        model.addAttribute("products", list);
        return "account/settleAccount";
    }

    /**
     * @param model
     * @param request
     * @return 购买成功返回json
     * 实现买家购买商品功能
     */
    @PreAuthorize("hasAuthority('BUYER')")
    @RequestMapping(path = {"/api/buy"}, method = {RequestMethod.POST})
    @ResponseBody
    public JSONObject buy(Model model, HttpServletRequest request){
        StringBuffer msg = new StringBuffer();
        String lineString  = null;
        try {
            BufferedReader reader = request.getReader();
            while((lineString = reader.readLine()) != null){
                msg.append(lineString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = JSON.parseArray(msg.toString());
        for(int i = 0; i < jsonArray.size(); i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            int id = Integer.valueOf(jsonObject.getString("id"));
            int number = Integer.valueOf(jsonObject.getString("number"));
            Commodity commodity = commodityService.getCommodityDetailByPrimaryKey(id);//获取商品信息
            commodityService.updateCommodityStatusAndNum(commodity, number);//设置商品销售状态
            if(commodity != null)
                buyerService.addAccount(commodity, number);
            System.out.println(id + ":" + number);
        }
        JSONObject json = new JSONObject();
        json.put("code", CodeUtil.SUCCESS.getCode());
        json.put("result", CodeUtil.SUCCESS.getResult());
        json.put("message", "buy ok");
        return json;
    }
}
