package com.contrat.api.config;

import com.contrat.api.utils.ERC721;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;

@Configuration
public class ERC721Config {
    @Bean
    public ERC721 myContract() {
        ERC721 Contract = null;
        try {
            // 以太坊测试网络api
            String apiUrl = "https://rinkeby.infura.io/v3/1c0501c9704f4d99b4b9acb30534d60d";
            // web3j对象
            Web3j web3j = Web3j.build(new HttpService(apiUrl));
            // gasPrice
            BigInteger gasPrice1 = web3j.ethGasPrice().sendAsync().get().getGasPrice();
            // 读取keystore文件；
            String filePath = "static/keystore/UTC--2018-11-06T05-56-28.110Z--a387ad547b44f70b5c074f815ec5267d998c0f67";
            //对keystore进行操作；
            String proPath = ResourceUtils.getURL("classpath:").getPath() + filePath;
            Credentials credentials = WalletUtils.loadCredentials("yycjmx1314", proPath.substring(1));
            // 实例化合约对象
            Contract = new ERC721("0x11f2a42ae346b8f2ee9d584bad904e09b8f731c1", web3j, credentials, gasPrice1, BigInteger.valueOf(100000));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Contract;
    }
}
