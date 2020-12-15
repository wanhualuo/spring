package com.abc.service.impl;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.common.ResEnum;
import com.abc.dao.entity.Dept;
import com.abc.dao.factory.DaoFactory;
import com.abc.dao.idao.IDeptDao;
import com.abc.service.iservice.IDeptService;

import java.util.ArrayList;
import java.util.List;

public class IDeptServiceImpl implements IDeptService {
    IDeptDao iDeptDao;

    public IDeptServiceImpl() {
        iDeptDao = (IDeptDao) DaoFactory.getInstance(Comm.DEPT);
    }

    @Override
    public Res<List<Dept>> findAll() {
        List<Dept> depts = new ArrayList<Dept>();
        try {
            depts = iDeptDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (depts != null && depts.size() >0)?Res.sucess(ResEnum.SUCCESS,depts):Res.error();
    }
}
