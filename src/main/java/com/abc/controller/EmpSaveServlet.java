package com.abc.controller;

import com.abc.common.Comm;
import com.abc.dao.entity.Emp;
import com.abc.service.factory.ServiceFactory;
import com.abc.service.iservice.IEmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "/EmpSaveServlet",urlPatterns = {"/empsave"})
public class EmpSaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ename = request.getParameter("ename");
        Date hiredate = null;
        try {
            hiredate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hiredate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        BigDecimal sal = new BigDecimal(request.getParameter("sal"));
        IEmpService empService = (IEmpService) ServiceFactory.getInstance(Comm.EMP);
        Emp emp = new Emp(ename, hiredate, sal);

        String msg = empService.save(emp);
        //3--反馈
        if (Comm.SUCCESS.equals(msg)) {
            //重定向
            response.sendRedirect(request.getContextPath() + "/empbypage");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("errMsg", "员工数据插入失败");
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }


}
