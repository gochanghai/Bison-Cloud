package com.bison.system.service.impl;

import com.bison.system.domain.SysUser;
import com.bison.system.mapper.SysUserMapper;
import com.bison.system.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author changhai.liu
 * @since 2020-08-06
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
