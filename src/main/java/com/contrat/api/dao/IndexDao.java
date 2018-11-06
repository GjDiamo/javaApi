package com.contrat.api.dao;
import com.contrat.api.utils.ERC721;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.web3j.abi.datatypes.Address;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
/**
 * 外部数据获取层，如调用web3j时，在此类中实现
 */
@Component
public class IndexDao {
    public String index() { return "hello, world!"; }
    public String getbalance(String address) { return null; }

    /**
     * 调用合约方式根据钱包地址查询账户PCT余额
     * @param address 钱包地址
     * @return
     * @throws Exception
     */
    public static BigInteger getBalance(String address) throws Exception {
        // 以太坊测试网络api
        String apiUrl = "https://rinkeby.infura.io/v3/1c0501c9704f4d99b4b9acb30534d60d";
        // web3j对象
        Web3j web3j = Web3j.build(new HttpService(apiUrl));
        // gasPrice
        BigInteger gasPrice1 = web3j.ethGasPrice().sendAsync().get().getGasPrice();
        // 读取keystore文件
        String filePath = "static/keystore/UTC--2018-11-06T05-56-28.110Z--a387ad547b44f70b5c074f815ec5267d998c0f67";
        //“classpath”是什么？
        String proPath = ResourceUtils.getURL("classpath:").getPath() + filePath;
        Credentials credentials = WalletUtils.loadCredentials("yycjmx1314", proPath.substring(1));
        // 实例化合约对象
        ERC721 pct = new ERC721("0x11f2a42ae346b8f2ee9d584bad904e09b8f731c1", web3j, credentials, gasPrice1, BigInteger.valueOf(100000));
        // 调用合约方法查询余额
        Address addressObj = new Address(address);
        BigInteger balance = pct.balanceOf(addressObj).sendAsync().get().getValue();
        return balance;
    }

    public static void main(String[] args) throws Exception {
        BigInteger balance = getBalance("0x1Da75899D96934939b96af36c206c88540624545");
        System.out.println(balance);
    }
}
