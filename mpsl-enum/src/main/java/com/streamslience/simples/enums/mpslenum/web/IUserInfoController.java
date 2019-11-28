package com.streamslience.simples.enums.mpslenum.web;

import com.streamslience.simples.enums.mpslenum.entity.UserInfoEntity;
import com.streamslience.simples.enums.mpslenum.util.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author StreamSlience
 * @description
 * @creatdate 2019-11-28 19:40
 */
@Api(description = "用户信息", tags = "用户信息")
@RequestMapping(value = "user", method = RequestMethod.POST)
public interface IUserInfoController {

    @RequestMapping(value = "getUserInfo.htm", method = RequestMethod.GET)
    Result<UserInfoEntity> getUserInfo(@RequestParam("id") String id);

}
