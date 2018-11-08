package com.contrat.api.service.impl;
import com.contrat.api.service.IndexService;
import com.contrat.api.utils.ERC721;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Uint;
import org.web3j.abi.datatypes.generated.Uint256;

import java.math.BigInteger;

/**
 * service实现类，具体实现业务类
 */

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    ERC721 myContract;

    @Override
    //获取合约发行代币总量
    public BigInteger getTotal() throws Exception {
        BigInteger totalSupply = myContract.totalSupply().sendAsync().get().getValue();
        return totalSupply;
    }

    @Override
    //获取指定账户余额
    public BigInteger getbalance(String address) throws Exception {
        Address addressObj = new Address(address);
        BigInteger balance = myContract.balanceOf(addressObj).sendAsync().get().getValue();
        return balance;
    }

    @Override
    //获取合约地址
    public String getContractAddress(){
        String address= myContract.getContractAddress();
        return address;
    }

    @Override
    //指定ID确认归属地址；
    public String getOwnerOfById(String tokenID) throws Exception {
        Uint256 uint256 = new Uint256(new BigInteger(tokenID));
        String address= myContract.ownerOf(uint256).sendAsync().get().getValue();
        return address;
    }



}
