package com.bison.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 参数配置表
 * </p>
 *
 * @author changhai.liu
 * @since 2020-08-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysConfig对象", description="参数配置表")
public class SysConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "参数主键")
    @TableId(value = "config_id", type = IdType.AUTO)
    private Integer configId;

    @ApiModelProperty(value = "参数名称")
    private String configName;

    @ApiModelProperty(value = "参数键名")
    private String configKey;

    @ApiModelProperty(value = "参数键值")
    private String configValue;

    @ApiModelProperty(value = "系统内置（Y是 N否）")
    private String configType;

    @ApiModelProperty(value = "创建者")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新者")
    private String updateBy;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "备注")
    private String remark;


}
