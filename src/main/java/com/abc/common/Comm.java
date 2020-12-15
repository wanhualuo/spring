package com.abc.common;

public interface Comm {
    //不是接口的写法
   // public  static  final  String USER="user";
    //在接口中直接写 前面的public  static  final会自动添加
    //一张表一个常量 假如有五十张表就是有50个常量
    String USER="user";
    String CURRENT_USER = "current_user";
    String SUCCESS = "success";
    String ERROR = "error";
    String EMP = "emp";
    String DEPT= "dept";
    String DEPT_EMP_REPORT="dept_emp_report";
}
