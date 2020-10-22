package com.bison.file.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @description:
 * @author: Changhai.liu
 * @date: 2020/10/21 21:56
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EmailSendHist对象", description="文件信息表")
public class EmailSendHist {

    private Integer id;

    private String fromAddress;

    private String toAddress;

    private String subject;

    private String body;

    private String template;

    private String language;

    private Boolean success;

    private String error;

    private LocalDateTime createTime;

}
