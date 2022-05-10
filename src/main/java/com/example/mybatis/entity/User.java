package com.example.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author kylin
 */
@Data
@TableName(value = "")
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;

}
