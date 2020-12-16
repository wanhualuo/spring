package com.abc.ssm.spring;

import org.springframework.stereotype.Repository;

@Repository("personDao")
public class PersonDao {
    public void print() {
        System.out.println("inperson");
    }
}
