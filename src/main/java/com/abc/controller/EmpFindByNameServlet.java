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
import java.io.IOException;
import java.util.List;

@WebServlet(name = "/EmpFindByNameServlet",urlPatterns = {"/empbyname"})
public class EmpFindByNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ename = request.getParameter("ename");

        //2--处理
        IEmpService empService = (IEmpService) ServiceFactory.getInstance(Comm.EMP);
        List<Emp> emps = empService.findByName(ename);

        //3--反馈 使用Java模板引擎
        if (emps != null && emps.size() > 0) {
            System.out.println(emps);
            request.setAttribute("empsFromService",emps);
            request.getRequestDispatcher("/emps.jsp").forward(request,response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("errMsg","模糊查询失败");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }


}
