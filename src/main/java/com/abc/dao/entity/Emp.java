package com.abc.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private int empno;
    private String ename;
    private Date hiredate;
    private BigDecimal sal;

    public Emp(String ename, Date hiredate, BigDecimal sal) {
        this.ename = ename;
        this.hiredate = hiredate;
        this.sal = sal;
    }
}
