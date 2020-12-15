package com.abc.service.dto;

import java.math.BigDecimal;

public class DeptEmpDTO {
    private String dname;
    private String loc;
    private String ename;
    private BigDecimal sal;

    public DeptEmpDTO() {
    }

    public DeptEmpDTO(String dname, String loc, String ename, BigDecimal sal) {
        this.dname = dname;
        this.loc = loc;
        this.ename = ename;
        this.sal = sal;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "DeptEmpDto{" +
                "dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                ", ename='" + ename + '\'' +
                ", sal=" + sal +
                '}';
    }
}
