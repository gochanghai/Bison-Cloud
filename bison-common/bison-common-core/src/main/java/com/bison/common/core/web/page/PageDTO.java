package com.bison.common.core.web.page;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Changhai.liu
 * @decs:
 * @date 2020/6/20 10:10
 */
public class PageDTO implements Serializable {

    private static final long serialVersionUID = 7754159643145458588L;

    public PageDTO() {
    }

    /**
     * 构造器
     **/
    public PageDTO(Map<String, Object> params) {
        this.pageNow = 1;
        this.pageSize = 10;
        if (params.get("pageNow") != null) {
            this.pageNow = Integer.parseInt(params.get("pageNow").toString());
        }
        if (params.get("pageSize") != null) {
            this.pageSize = Integer.parseInt(params.get("pageSize").toString());
        }
        if (params.get("orderBy") != null) {
            this.orderBy = params.get("orderBy").toString();
        }
    }

    /**
     * 当前页
     */
    private Integer pageNow;

    /**
     * 查询数量
     */
    private Integer pageSize;

    /**
     * 排序字段
     */
    private String orderBy;

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNow() {
        return pageNow == null ? 1 : pageNow;
    }

    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    public Integer getPageSize() {
        return pageSize == null ? 10 : pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public String getCamelCaseOrderBy() {

        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

}
