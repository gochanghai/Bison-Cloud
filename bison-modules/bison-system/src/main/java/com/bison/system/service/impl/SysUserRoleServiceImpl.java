package com.bison.system.service.impl;

import com.bison.system.domain.SysUserRole;
import com.bison.system.mapper.SysUserRoleMapper;
import com.bison.system.service.ISysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author changhai.liu
 * @since 2020-08-06
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

}
