package com.streamslience.simples.dynamic.mpsldynamicdatasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.streamslience.simples.dynamic.mpsldynamicdatasource.dao.AddressInfoDao;
import com.streamslience.simples.dynamic.mpsldynamicdatasource.service.AddressInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author StreamSlience
 * @description
 * @creatdate 2019-12-09 11:06
 */
@Service
@DS("slave_1")
public class AddressInfoImpl implements AddressInfoService {

    @Autowired
    private AddressInfoDao addressInfoDao;

    @Override
    public void Insert(String address) {
        addressInfoDao.Insert(UUID.randomUUID().toString().replaceAll("-", ""), address);
    }

    @Override
    public int update(String id, String address) {
        return addressInfoDao.update(id, address);
    }
}
