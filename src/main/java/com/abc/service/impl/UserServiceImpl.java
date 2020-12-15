package com.abc.service.impl;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.common.ResEnum;
import com.abc.dao.entity.User;
import com.abc.dao.factory.DaoFactory;
import com.abc.dao.idao.IUserDao;
import com.abc.service.iservice.IUserService;

//处理dao文件夹里面sql语句的查询结果
public class UserServiceImpl implements IUserService {
    IUserDao userDao;

    public UserServiceImpl() {
        userDao = (IUserDao) DaoFactory.getInstance(Comm.USER);
    }

    @Override
    public Res userExist(String username) {
        int flag = 0;
        try {
            flag = userDao.exist(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //给对应的查询结果赋上对应的值
        return flag>0?Res.sucess(ResEnum.SUCCESS_USER_EXIST):Res.error(ResEnum.ERROR_USER_EXIST);
    }

    @Override
    public Res<User> login(User user) {
        User result = null;
        try{
          result = userDao.login(user);
        }catch(Exception e){
            e.printStackTrace();
        }
        if(result != null){
            //对信息进行过滤
            result.setPassword("");
            return  Res.sucess(ResEnum.SUCCESS,result);
        }
        return Res.error(ResEnum.ERROR);
    }
}
