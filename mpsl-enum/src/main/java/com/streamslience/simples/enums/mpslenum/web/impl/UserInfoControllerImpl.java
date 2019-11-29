package com.streamslience.simples.enums.mpslenum.web.impl;

import com.streamslience.simples.enums.mpslenum.dao.UserInfoDao;
import com.streamslience.simples.enums.mpslenum.entity.UserInfoEntity;
import com.streamslience.simples.enums.mpslenum.util.ApiResponseCode;
import com.streamslience.simples.enums.mpslenum.util.Result;
import com.streamslience.simples.enums.mpslenum.web.IUserInfoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author StreamSlience
 * @description
 * @creatdate 2019-11-28 19:40
 */
@RestController
public class UserInfoControllerImpl implements IUserInfoController {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public Result<UserInfoEntity> getUserInfo(String id) {
        Result<UserInfoEntity> result = new Result<>(ApiResponseCode.SUCCESS.get(), ApiResponseCode.SUCCESS.getName());

        UserInfoEntity user = userInfoDao.selectById(id);
        user.getUserNationality().name();
        user.getUserNationality().getCode();
        user.getUserNationality().getValue();

        System.err.println(user);
        result.setDatas(user);

        return result;
    }
}
