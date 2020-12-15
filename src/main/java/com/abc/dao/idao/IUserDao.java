package com.abc.dao.idao;

import com.abc.dao.entity.User;

public interface IUserDao {

    int exist(String username) throws Exception;

    User login(User user)throws Exception;
}
