package com.abc.service.impl;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.common.ResEnum;
import com.abc.controller.vo.DelVO;
import com.abc.dao.entity.Emp;
import com.abc.dao.factory.DaoFactory;
import com.abc.dao.idao.IEmpDao;
import com.abc.service.iservice.IEmpService;

import java.util.List;

public class EmpServiceImpl implements IEmpService {
    IEmpDao empDao;

    public EmpServiceImpl() {
        empDao = (IEmpDao) DaoFactory.getInstance(Comm.EMP);
    }

    @Override
    public List<Emp> findByPage(int page, int size) {
        List<Emp> emps = null;
        try {
            emps = empDao.findByPage((page-1)*size,size);

        }catch (Exception e){
            e.printStackTrace();
        }

        return emps;
    }

    @Override
    public List<Emp> findByName(String name) {
        List<Emp> emps = null;
        try {
            emps = empDao.findByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emps;
    }
    @Override
    public Emp findById(Integer empno) {
        Emp emp = null;
        try {
            emp = empDao.findById(empno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }
    @Override
    public String delete(Emp emp) {
        String msg = Comm.ERROR;
        try {
            empDao.delete(emp);
            msg=Comm.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public String save(Emp emp) {
        String msg = Comm.ERROR;
        try {
            empDao.save(emp);
            msg=Comm.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public String update(Emp emp) {
        String msg = Comm.ERROR;
        try {
            empDao.update(emp);
            msg=Comm.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public Res<List<Emp>> findByDept(int deptno) {
        List<Emp> emps = null;
        try {
            emps = empDao.findByDept(deptno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (emps != null && emps.size()>0)?Res.sucess(ResEnum.SUCCESS,emps):Res.error();
    }

    @Override
    public Res delBatch(List<DelVO> delVOList) {
        //如果传来参数为空 直接返回 保证数据不为空
        if(delVOList == null && delVOList.size() == 0){
            return Res.error(ResEnum.ERROR_PARAMS_IN_DELBATCH);
        }
        try {
            empDao.delBatch(delVOList);
            return Res.sucess(ResEnum.SUCCESS_DEL_BATCH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Res.error();
    }
}
