package com.bison.file.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @description:
 * @author: Changhai.liu
 * @date: 2020/10/21 21:53
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EmailTemplate对象", description="文件信息表")
public class EmailTemplate {

    private Integer id;

    private String key;

    private String language;

    private String title;

    private String body;

    private String fromAccount;

    private String templateType;

    private String classify;
}
