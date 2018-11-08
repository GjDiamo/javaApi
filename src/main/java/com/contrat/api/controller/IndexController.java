package com.contrat.api.controller;
import com.contrat.api.service.IndexService;
import com.contrat.api.utils.ERC721;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.web3j.abi.datatypes.Uint;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;
/**
 * 接口类，api调用层
 */
@Controller
@RequestMapping("/api")
public class IndexController {
    @Autowired
    IndexService indexService;
    /**
     * 获取合约地址
     * @return
     */
    @RequestMapping("/vi/address")
    @ResponseBody
    public String getContractAddress() throws Exception {
        return indexService.getContractAddress();
    }
    /**
     * 获取合约代币总数目
     * @return
     */
    @RequestMapping("/vi/total")
    @ResponseBody
    public BigInteger index() throws Exception {
        return indexService.getTotal();
    }
    /**
     * 获取代币总额
     * @return
     * @param :http://localhost:8080/api/vi/balance?address=0x61602D1a1cd1ea8B665218E75E95aF7Dec992a28
     */
    @RequestMapping("/vi/balance")
    @ResponseBody
    public BigInteger index(String address) throws Exception {
        return indexService.getbalance(address);
    }
    /**
     * 获取指定账户代币余额
     * @return
     */
    /**
     * 根据ID确认归属地址；
     * @return
     * @param ：http://localhost:8080/api/vi/owner?tokenID=1
     */
    @RequestMapping("/vi/owner")
    @ResponseBody
    public String getOwnerOfById(String tokenID)throws Exception{
        return  indexService.getOwnerOfById(tokenID);
    }

}
