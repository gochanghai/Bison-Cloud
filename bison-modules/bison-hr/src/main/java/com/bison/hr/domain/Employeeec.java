package com.bison.hr.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: Changhai
 * @time: 2020/8/4 23:36
 */
@Data
public class Employeeec implements Serializable {

    private Integer id;

    private Integer eid;

    private Date ecdate;

    private String ecreason;

    private Integer ecpoint;

    private Integer ectype;

    private String remark;
}
