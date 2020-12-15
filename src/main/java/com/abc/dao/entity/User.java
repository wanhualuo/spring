package com.abc.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor//有参构造
@NoArgsConstructor//无参构造
public class User {
    private int id;
    private String username;
    private String password;
    private int pri;

    public User(String username, String password, int pri) {
        this.username = username;
        this.password = password;
        this.pri = pri;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
