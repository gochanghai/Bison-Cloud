package com.bison.system.service.impl;

import com.bison.system.domain.SysOperLog;
import com.bison.system.mapper.SysOperLogMapper;
import com.bison.system.service.ISysOperLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志记录 服务实现类
 * </p>
 *
 * @author changhai.liu
 * @since 2020-08-06
 */
@Service
public class SysOperLogServiceImpl extends ServiceImpl<SysOperLogMapper, SysOperLog> implements ISysOperLogService {

}
