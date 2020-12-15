package com.abc.service.impl;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.service.factory.ServiceFactory;
import com.abc.service.iservice.IUserService;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {
    IUserService userService;
    private static  Logger log = Logger.getLogger(UserServiceImplTest.class);
    @Before
    public void setUp(){
        userService = (IUserService) ServiceFactory.getInstance(Comm.USER);
    }
    @Test
    public void userExist() {
        Res res = userService.userExist("root");
        log.info("******************"+ res);

    }
}