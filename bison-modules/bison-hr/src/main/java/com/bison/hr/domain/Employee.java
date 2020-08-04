package com.bison.hr.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Changhai
 * @time: 2020/8/4 23:36
 */
@Data
public class Employee implements Serializable {

    private Integer id;

    private String name;

    private String gender;
}
