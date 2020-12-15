package com.abc.dao.impl;

import com.abc.controller.vo.DeptEmpVO;
import com.abc.dao.entity.Emp;
import com.abc.dao.idao.IReportDao;
import com.abc.dao.util.DBUtil;
import com.abc.service.dto.DeptEmpDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReportDeptEmpDaoImpl implements IReportDao {
    @Override
    public List<DeptEmpDTO> makeReportForDeptEmp(DeptEmpVO deptEmpVO) throws Exception {
        Connection con = DBUtil.getConnection();
        String sql = "select d.dname,d.loc,e.ename,e.sal from dept d left join emp e on d.deptno=e.deptno where d.deptno=? and e.sal between ? and ?";
        PreparedStatement ps = con.prepareStatement(sql);
       /* System.out.println(deptEmpVO.getDeptno());
        System.out.println(deptEmpVO.getMinSal());
        System.out.println(deptEmpVO.getMaxSal());*/
        ps.setInt(1,deptEmpVO.getDeptno());
        ps.setBigDecimal(2,deptEmpVO.getMinSal());
        ps.setBigDecimal(3,deptEmpVO.getMaxSal());
        ResultSet rs = ps.executeQuery();
        List<DeptEmpDTO> dtos = new ArrayList<DeptEmpDTO>();
        while(rs.next()){
            DeptEmpDTO dto = new DeptEmpDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getBigDecimal(4));
            System.out.println("$%^&&^*&(*)(_*******1");
            dtos.add(dto);
        }
        DBUtil.close(rs,ps,con);
        return dtos;
    }
}
