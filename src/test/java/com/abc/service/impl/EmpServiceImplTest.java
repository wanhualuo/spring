package com.abc.service.impl;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.dao.entity.Emp;
import com.abc.dao.factory.DaoFactory;
import com.abc.dao.idao.IEmpDao;
import com.abc.service.factory.ServiceFactory;
import com.abc.service.iservice.IUserService;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EmpServiceImplTest {


    IEmpDao empDao;
    @Before
    public void setUp(){
        empDao = (IEmpDao) DaoFactory.getInstance(Comm.EMP);
    }

    @Test
    public void findByPage() throws Exception {
        List<Emp> emps = null;
        emps = empDao.findByPage(1,10);
        System.out.println("***************"+emps);
    }
}