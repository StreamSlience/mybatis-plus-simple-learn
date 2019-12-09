package com.streamslience.simples.dynamic.mpsldynamicdatasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.streamslience.simples.dynamic.mpsldynamicdatasource.dao.GoodsDao;
import com.streamslience.simples.dynamic.mpsldynamicdatasource.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author StreamSlience
 * @description
 * @creatdate 2019-12-09 10:35
 */
@Service
@DS("master")
public class GoodsImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public void insert(String goodsName) {
        goodsDao.insert(UUID.randomUUID().toString().replaceAll("-", ""), goodsName);
    }

    @Override
    public int delete(String goodsName) {
        return goodsDao.delete(goodsName);
    }
}
