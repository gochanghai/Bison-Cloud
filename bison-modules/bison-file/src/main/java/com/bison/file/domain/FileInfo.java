package com.bison.file.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 文件信息表 实体类
 * @author: Changhai.liu
 * @date: 2020/8/19 23:04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="FileInfo对象", description="文件信息表")
public class FileInfo implements Serializable {

    private static final long serialVersionUID = 1356257283938225230L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件后缀
     */
    private String fileSuffix;

    /**
     * URL地址
     */
    private String url;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 上传者
     */
    private String createBy;

    /**
     * 服务商
     */
    private Integer service;

}
