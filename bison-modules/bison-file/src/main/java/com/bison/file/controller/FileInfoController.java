package com.bison.file.controller;

import com.bison.common.core.web.controller.BaseController;
import com.bison.common.core.web.domain.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @description:
 * @author: Changhai.liu
 * @date: 2020/8/23 23:56
 */
@RestController
@RequestMapping("fileInfo")
public class FileInfoController extends BaseController {

    /**
     * 查询文件列表
     * @param param
     * @return
     */
    @GetMapping("list")
    public CommonResult list(Map<String, Object> param) {
        return CommonResult.success();
    }

    /**
     * 查询文件列表
     * @param businessId
     * @return
     */
    @GetMapping("listByBusinessId")
    public CommonResult listByBusinessId(Long businessId) {
        return CommonResult.success();
    }
}
