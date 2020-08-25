package com.bison.system.controller;


import com.bison.common.core.constant.UserConstants;
import com.bison.common.core.utils.poi.ExcelUtil;
import com.bison.common.core.web.controller.BaseController;
import com.bison.common.core.web.domain.CommonResult;
import com.bison.common.core.web.page.TableDataInfo;
import com.bison.common.log.annotation.Log;
import com.bison.common.log.enums.BusinessType;
import com.bison.common.security.utils.SecurityUtils;
import com.bison.system.domain.SysPost;
import com.bison.system.service.ISysPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 岗位信息表 前端控制器
 * </p>
 *
 * @author changhai.liu
 * @since 2020-08-06
 */
@RestController
@RequestMapping("/sysPost")
public class SysPostController extends BaseController {

    @Autowired
    private ISysPostService postService;

    /**
     * 获取岗位列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SysPost post) {
        startPage();
        List<SysPost> list = postService.selectPostList(post);
        return getDataTable(list);
    }

    @Log(title = "岗位管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysPost post) throws IOException {
        List<SysPost> list = postService.selectPostList(post);
        ExcelUtil<SysPost> util = new ExcelUtil<SysPost>(SysPost.class);
        util.exportExcel(response, list, "岗位数据");
    }

    /**
     * 根据岗位编号获取详细信息
     */
    @GetMapping(value = "/{postId}")
    public CommonResult getInfo(@PathVariable Long postId) {
        return CommonResult.success(postService.selectPostById(postId));
    }

    /**
     * 新增岗位
     */
    @Log(title = "岗位管理", businessType = BusinessType.INSERT)
    @PostMapping
    public CommonResult add(@Validated @RequestBody SysPost post) {
        if (UserConstants.NOT_UNIQUE.equals(postService.checkPostNameUnique(post))) {
            return CommonResult.error("新增岗位'" + post.getPostName() + "'失败，岗位名称已存在");
        } else if (UserConstants.NOT_UNIQUE.equals(postService.checkPostCodeUnique(post))) {
            return CommonResult.error("新增岗位'" + post.getPostName() + "'失败，岗位编码已存在");
        }
        post.setCreateBy(SecurityUtils.getUsername());
        return toResult(postService.insertPost(post));
    }

    /**
     * 修改岗位
     */
    @Log(title = "岗位管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public CommonResult edit(@Validated @RequestBody SysPost post) {
        if (UserConstants.NOT_UNIQUE.equals(postService.checkPostNameUnique(post))) {
            return CommonResult.error("修改岗位'" + post.getPostName() + "'失败，岗位名称已存在");
        } else if (UserConstants.NOT_UNIQUE.equals(postService.checkPostCodeUnique(post))) {
            return CommonResult.error("修改岗位'" + post.getPostName() + "'失败，岗位编码已存在");
        }
        post.setUpdateBy(SecurityUtils.getUsername());
        return toResult(postService.updatePost(post));
    }

    /**
     * 删除岗位
     */
    @Log(title = "岗位管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{postIds}")
    public CommonResult remove(@PathVariable Long[] postIds) {
        return toResult(postService.deletePostByIds(postIds));
    }

    /**
     * 获取岗位选择框列表
     */
    @GetMapping("/optionselect")
    public CommonResult optionselect() {
        List<SysPost> posts = postService.selectPostAll();
        return CommonResult.success(posts);
    }
}
