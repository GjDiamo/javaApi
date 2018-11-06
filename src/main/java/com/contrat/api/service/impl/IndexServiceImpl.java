package com.contrat.api.service.impl;
import com.contrat.api.dao.IndexDao;
import com.contrat.api.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * service实现类，具体实现业务类
 */

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    IndexDao indexDao;

    @Override
    public String index() {
        return indexDao.index();
    }

    @Override
    public String getbalance(String address) {
        return indexDao.getbalance(address);
    }
}
