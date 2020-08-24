package com.bison.system.controller;


import com.bison.common.core.utils.poi.ExcelUtil;
import com.bison.common.core.web.controller.BaseController;
import com.bison.common.core.web.domain.CommonResult;
import com.bison.common.core.web.page.TableDataInfo;
import com.bison.common.log.annotation.Log;
import com.bison.common.log.enums.BusinessType;
import com.bison.common.security.utils.SecurityUtils;
import com.bison.system.domain.SysDictData;
import com.bison.system.service.ISysDictDataService;
import com.bison.system.service.ISysDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 字典数据 前端控制器
 * </p>
 *
 * @author changhai.liu
 * @since 2020-08-06
 */
@RestController
@RequestMapping("/sysDictData")
public class SysDictDataController extends BaseController {

    @Autowired
    private ISysDictDataService dictDataService;

    @Autowired
    private ISysDictTypeService dictTypeService;

    @GetMapping("/list")
    public TableDataInfo list(SysDictData dictData) {
        startPage();
        List<SysDictData> list = dictDataService.selectDictDataList(dictData);
        return getDataTable(list);
    }

    @Log(title = "字典数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysDictData dictData) throws IOException {
        List<SysDictData> list = dictDataService.selectDictDataList(dictData);
        ExcelUtil<SysDictData> util = new ExcelUtil<SysDictData>(SysDictData.class);
        util.exportExcel(response, list, "字典数据");
    }

    /**
     * 查询字典数据详细
     */
    @GetMapping(value = "/{dictCode}")
    public CommonResult getInfo(@PathVariable Long dictCode) {
        return CommonResult.success(dictDataService.selectDictDataById(dictCode));
    }

    /**
     * 根据字典类型查询字典数据信息
     */
    @GetMapping(value = "/type/{dictType}")
    public CommonResult dictType(@PathVariable String dictType) {
        return CommonResult.success(dictTypeService.selectDictDataByType(dictType));
    }

    /**
     * 新增字典类型
     */
    @Log(title = "字典数据", businessType = BusinessType.INSERT)
    @PostMapping
    public CommonResult add(@Validated @RequestBody SysDictData dict) {
        dict.setCreateBy(SecurityUtils.getUsername());
        return toResult(dictDataService.insertDictData(dict));
    }

    /**
     * 修改保存字典类型
     */
    @Log(title = "字典数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public CommonResult edit(@Validated @RequestBody SysDictData dict) {
        dict.setUpdateBy(SecurityUtils.getUsername());
        return toResult(dictDataService.updateDictData(dict));
    }

    /**
     * 删除字典类型
     */
    @Log(title = "字典类型", businessType = BusinessType.DELETE)
    @DeleteMapping("/{dictCodes}")
    public CommonResult remove(@PathVariable Long[] dictCodes) {
        return toResult(dictDataService.deleteDictDataByIds(dictCodes));
    }
}
