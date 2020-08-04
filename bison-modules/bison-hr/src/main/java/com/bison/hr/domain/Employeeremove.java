package com.bison.hr.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: Changhai
 * @time: 2020/8/4 23:34
 */
@Data
public class Employeeremove implements Serializable {

    private Integer id;

    private Integer eid;

    private Integer afterdepid;

    private Integer afterjobid;

    private Date removedate;

    private String reason;

    private String remark;
}
