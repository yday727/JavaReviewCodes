package com.yday72__7.reviewCodes.stream.serialization;

import java.io.Serial;
import java.io.Serializable;

// 一个实现可序列化接口的类
public class User implements Serializable {
    @Serial
    // serialVersionUID字段显示声明版本号，避免反序列化兼容性问题
    private static final long serialVersionUID = 1L;
    private String name;
    // transient关键字修饰的字段/方法不参与序列化
    transient private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", password=" + password + '}';
    }
}
