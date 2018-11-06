package com.contrat.api.controller;

import com.contrat.api.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 接口类，api调用层
 */
@Controller
@RequestMapping("/api")
public class IndexController {
    @Autowired
    IndexService indexService;
    @RequestMapping("/vi/hello")
    @ResponseBody
    public String index() {
        return indexService.index();
    }
    /**
     * 获取余额
     * @return
     */
    @RequestMapping("/vi/balance")
    @ResponseBody
    public String index(String address) {
        return indexService.getbalance(address);
    }

}
