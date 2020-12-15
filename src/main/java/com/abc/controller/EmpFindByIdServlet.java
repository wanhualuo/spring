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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "/EmpFindByIdServlet",urlPatterns = {"/empbyid"})
public class EmpFindByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empno = 0;

        String empnoParam = request.getParameter("empno");

        //传参的时候需要对完整性进行校验 防止漏洞
        if(empnoParam != null && !"".equals(empnoParam.trim())){
            empno = Integer.parseInt(empnoParam);
        }

        //2--处理
        IEmpService empService = (IEmpService) ServiceFactory.getInstance(Comm.EMP);
        List<Emp> emps = new ArrayList<Emp>();
        Emp emp = empService.findById(empno);
        emps.add(emp);
        //3--反馈 使用Java模板引擎

        if (emps != null && emps.size() > 0) {
            System.out.println(emps);
            request.setAttribute("empsFromService",emps);
            request.getRequestDispatcher("/emps.jsp").forward(request,response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("errMsg","精确查询失败");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }

    //用来过滤更新 在点就修改时自动跳转到该页面 先判断该用户是否存在 然后再跳转updateemp.jsp页面进行输入传送
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int empno = 0;
        String empnoParam = request.getParameter("empno");
        if(empnoParam != null && !"".equals(empnoParam.trim())){
            empno = Integer.parseInt(empnoParam);
        }
        IEmpService empService = (IEmpService) ServiceFactory.getInstance(Comm.EMP);
        Emp emp = empService.findById(empno);
        if (emp != null) {
            request.setAttribute("empsFromService",emp);
            request.getRequestDispatcher("/updateemp.jsp").forward(request,response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("errMsg","员工信息不存在");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
}
