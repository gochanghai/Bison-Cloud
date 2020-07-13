package com.bison.common.core.web.page;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Changhai.liu
 * @decs:
 * @date 2020/6/20 9:59
 */

public class PageBean<T> implements Serializable {

    private static final long serialVersionUID = 8656597559014685635L;

    /***
     * 总记录数
     */
    private int total;

    /***
     * 结果集
     */
    private List<T> list;

    /***
     * 第几页
     */
    private int pageNum;
    /***
     * 每页记录数
     */
    private int pageSize;

    /***
     * 总页数
     */
    private int pages;

    /***
     * 当前页的数量 <= pageSize，该属性来自ArrayList的size属性
     */
    private int size;

    /***
     * sEcho datatables
     */
    private Integer sEcho;

    /**
     * 包装Page对象，因为直接返回Page对象，在JSON处理以及其他情况下会被当成List来处理， 而出现一些问题。
     *
     * @param list page结果
     */
    public PageBean(List<T> list) {
        if (list instanceof Page) {
            Page<T> page = (Page<T>) list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.total = (int) page.getTotal();
            this.pages = page.getPages();
            this.list = page;
            this.size = page.size();
        } else {
            this.list = new ArrayList();
        }
    }

    public PageBean() {
        this.pageNum = 1;
        this.pageSize = 10;
        this.total = 0;
        this.pages = 0;
        this.size = 0;
        this.list = new ArrayList();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Integer getsEcho() {
        return sEcho;
    }

    public void setsEcho(Integer sEcho) {
        this.sEcho = sEcho;
    }
}