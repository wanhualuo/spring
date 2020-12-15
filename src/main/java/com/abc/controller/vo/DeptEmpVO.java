package com.abc.controller.vo;

import java.math.BigDecimal;

public class DeptEmpVO {
    private int deptno;
    private BigDecimal minSal;
    private BigDecimal maxSal;

    public DeptEmpVO(int deptno, BigDecimal minSal, BigDecimal maxSal) {
        this.deptno = deptno;
        this.minSal = minSal;
        this.maxSal = maxSal;
    }

    public DeptEmpVO() {
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public BigDecimal getMinSal() {
        return minSal;
    }

    public void setMinSal(BigDecimal minSal) {
        this.minSal = minSal;
    }

    public BigDecimal getMaxSal() {
        return maxSal;
    }

    public void setMaxSal(BigDecimal maxSal) {
        this.maxSal = maxSal;
    }

    @Override
    public String toString() {
        return "DeptEmpCon{" +
                "deptno=" + deptno +
                ", minSal=" + minSal +
                ", maxSal=" + maxSal +
                '}';
    }
}
