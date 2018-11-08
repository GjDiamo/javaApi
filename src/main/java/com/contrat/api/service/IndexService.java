package com.contrat.api.service;

import java.math.BigInteger;

/**
 * 业务逻辑接口层，具体代码实现在该接口实现类中
 */

public interface IndexService {

    BigInteger getbalance(String address) throws Exception;

    BigInteger getTotal() throws Exception;

    String getContractAddress() throws Exception;

    //指定ID确认归属地址；
    String getOwnerOfById(String tokenID) throws Exception;
}
