package com.contrat.api.utils;
//这个是怎么继承过来的？目的为何？
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;

import java.math.BigInteger;

public class ERC721 extends Erc721_sol_ERC721 {
    public ERC721(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }
}
