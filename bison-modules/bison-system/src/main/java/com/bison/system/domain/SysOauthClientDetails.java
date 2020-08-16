package com.bison.system.domain;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 终端配置表
 * </p>
 *
 * @author changhai.liu
 * @since 2020-08-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysOauthClientDetails对象", description="终端配置表")
public class SysOauthClientDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "终端编号")
    private String clientId;

    @ApiModelProperty(value = "资源ID标识")
    private String resourceIds;

    @ApiModelProperty(value = "终端安全码")
    private String clientSecret;

    @ApiModelProperty(value = "终端授权范围")
    private String scope;

    @ApiModelProperty(value = "终端授权类型")
    private String authorizedGrantTypes;

    @ApiModelProperty(value = "服务器回调地址")
    private String webServerRedirectUri;

    @ApiModelProperty(value = "访问资源所需权限")
    private String authorities;

    @ApiModelProperty(value = "设定终端的access_token的有效时间值（秒）")
    private Integer accessTokenValidity;

    @ApiModelProperty(value = "设定终端的refresh_token的有效时间值（秒）")
    private Integer refreshTokenValidity;

    @ApiModelProperty(value = "附加信息")
    private String additionalInformation;

    @ApiModelProperty(value = "是否登录时跳过授权")
    private Integer autoapprove;


}
