package com.bison.system.service.impl;

import com.bison.system.domain.SysUserPost;
import com.bison.system.mapper.SysUserPostMapper;
import com.bison.system.service.ISysUserPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与岗位关联表 服务实现类
 * </p>
 *
 * @author changhai.liu
 * @since 2020-08-06
 */
@Service
public class SysUserPostServiceImpl extends ServiceImpl<SysUserPostMapper, SysUserPost> implements ISysUserPostService {

}
