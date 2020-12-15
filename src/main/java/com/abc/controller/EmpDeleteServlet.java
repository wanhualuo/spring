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

@WebServlet(name = "/UserDeletServlet",urlPatterns = {"/empdelete"})
public class EmpDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1--取值
        int empno = Integer.parseInt(request.getParameter("empno"));
        //2--处理
        IEmpService empService = (IEmpService) ServiceFactory.getInstance(Comm.EMP);
        Emp emp = new Emp();
        emp.setEmpno(empno);
        String msg = empService.delete(emp);
        //3--反馈
        if(Comm.SUCCESS.equals(msg)){
            //重定向
            response.sendRedirect(request.getContextPath()+"/empbypage");
        }else{
            HttpSession session = request.getSession();
            session.setAttribute("errMsg","员工数据删除失败");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }

    }

}
