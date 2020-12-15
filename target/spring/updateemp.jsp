<%--
  Created by IntelliJ IDEA.
  User: 落凤
  Date: 2020/12/4
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/empupdate" method="post">
    <table>
        <tr>
            <td>员工编号</td>
            <td>${empsFromService.empno}<input hidden type="text" name="empno" value="${empsFromService.empno}"></td>
        </tr>
        <tr>
            <td>员工姓名</td>
            <td><input type="text" name="ename" value="${empsFromService.ename}"></td>
        </tr>
        <tr>
            <td>入职日期</td>
            <td><input type="Date" name="hiredate" value="${empsFromService.hiredate}"></td>
        </tr>
        <tr>
            <td>薪资</td>
            <td><input type="text" name="sal" value="${empsFromService.sal}"></td>
        </tr>
        <tr>
            <td><input type="submit" value="更新"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
