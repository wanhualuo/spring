package com.abc.controller.report;

import com.abc.common.Comm;
import com.abc.common.Res;
import com.abc.controller.vo.DeptEmpVO;
import com.abc.service.dto.DeptEmpDTO;
import com.abc.service.factory.ServiceFactory;
import com.abc.service.iservice.IReportService;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

@WebServlet(name = "DeptEmpReportServlet",urlPatterns = {"/reportdeptemp"})
public class DeptEmpReportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int deptno = Integer.parseInt(request.getParameter("deptno"));
        BigDecimal minSal = new BigDecimal(request.getParameter("min"));
        BigDecimal maxSal = new BigDecimal(request.getParameter("max"));
        //组装VO vo是从页面获取的数据 dto是从servlet获取的数据
        DeptEmpVO deptEmpVO = new DeptEmpVO(deptno,minSal,maxSal);
        IReportService reportService = (IReportService) ServiceFactory.getInstance(Comm.DEPT_EMP_REPORT);
        Res<List<DeptEmpDTO>> res = reportService.makeReportForDeptEmp(deptEmpVO);
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String resJson = JSON.toJSONString(res);
        out.println(resJson);
        out.close();
    }

}
