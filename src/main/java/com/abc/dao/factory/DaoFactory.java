package com.abc.dao.factory;

import com.abc.common.Comm;
import com.abc.dao.impl.DeptDaoImpl;
import com.abc.dao.impl.EmpDaoImpl;
import com.abc.dao.impl.ReportDeptEmpDaoImpl;
import com.abc.dao.impl.UserDaoImpl;

public class DaoFactory {
    public static Object getInstance(String daoName){
        switch (daoName){
            case Comm.USER:
                return new UserDaoImpl();
            case Comm.EMP:
                return new EmpDaoImpl();
            case Comm.DEPT:
                return new DeptDaoImpl();
            case Comm.DEPT_EMP_REPORT:
                return new ReportDeptEmpDaoImpl();
            default:
                return  null;

        }
    }
}
