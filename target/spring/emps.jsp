
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
        td{
            width: 120px;
            height: 30px;
            text-align: center;

        }
        tr:nth-child(even){
            background-color: aqua;
        }
        td:hover{
            background-color: antiquewhite;
        }
    </style>
</head>
<body>
<table boder="1" id="empsInfo">
   
    <tr>
        <td>empno</td>
        <td>ename</td>
        <td>hiredate</td>
        <td>sal</td>
        <td>operation</td>
    </tr>

    <%--JSTL+EL表达式+JSP--%>
    <c:forEach items="${empsFromService}" var="emp">
        <tr>
            <td>${emp.empno}</td>
            <td>${emp.ename}</td>
            <td>${emp.hiredate}</td>
            <td>${emp.sal}</td>
                                                <%--el表达式--%>
            <td><a href="${pageContext.request.contextPath}/empbyid?empno=${emp.empno}">修改</a>    <a href="${pageContext.request.contextPath}/empdelete?empno=${emp.empno}" onclick="return confirm('确定删除吗？')">删除</a></td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/newemp.jsp">新增</a>
<hr>
<form action="${pageContext.request.contextPath}/empbyid" method="post">
    EMPNO:<input type="text" name="empno" placeholder="输入员工编号">
    <input type="submit" value="精确查询">
</form>
<hr>
<form action="${pageContext.request.contextPath}/empbyname" method="post">
    ENAME:<input type="text" name="ename" placeholder="输入员工姓名">
    <input type="submit" value="模糊查询">
</form>
</body>
</html>
