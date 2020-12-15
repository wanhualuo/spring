package com.abc.dao.idao;

import com.abc.controller.vo.DelVO;
import com.abc.dao.entity.Emp;

import java.util.List;

public interface IEmpDao {
    List<Emp> findByPage(int start, int size) throws Exception;

    Emp findById(Integer empno) throws Exception;
    List<Emp> findByName(String ename) throws Exception;

    void delete(Emp emp)throws Exception;
    void save(Emp emp)throws Exception;
    void update(Emp emp)throws Exception;


    List<Emp> findByDept(int deptno)throws Exception;

    void delBatch(List<DelVO> delVOList) throws Exception;
}
