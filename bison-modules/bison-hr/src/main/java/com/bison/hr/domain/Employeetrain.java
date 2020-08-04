package com.bison.hr.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: Changhai.liu
 * @time: 2020/8/4 23:35
 */
@Data
public class Employeetrain implements Serializable {

    private Integer id;

    private Integer eid;

    private Date traindate;

    private String traincontent;

    private String remark;
}
