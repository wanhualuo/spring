package com.abc.service.iservice;

import com.abc.common.Res;
import com.abc.dao.entity.User;

public interface IUserService {
    Res userExist(String username);

    Res<User> login(User user);
}
