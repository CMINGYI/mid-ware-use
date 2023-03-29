package com.chengming.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

/**
 * @Author: yichengming
 * @Date: 2021/10/28/22:58
 * @Description:
 */
@Data
@TableName(value = "user")
@AllArgsConstructor
public class User {


    private Integer id;

    private String name;

    private int age;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o != null && getClass().equals(o.getClass())) return true;

        User user = (User) o;

        return user != null && Objects.equals(user.name, name) && Objects.equals(user.age, age);

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


}
