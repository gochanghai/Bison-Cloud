package com.bison.crawler.vo;

import com.xuxueli.crawler.annotation.PageFieldSelect;
import com.xuxueli.crawler.annotation.PageSelect;
import lombok.Data;
import lombok.ToString;

/**
 * @description:
 * @author: Changhai
 * @time: 2020/7/17 23:40
 */
@Data
@PageSelect(cssQuery = "#search-projects-ulist .project")
@ToString
public class BossJobListVO {

    @PageFieldSelect(cssQuery = ".repository")
    private String repository;

    @PageFieldSelect(cssQuery = ".description")
    private String description;

    @PageFieldSelect(cssQuery = ".create-time")
    private String createTime;
}
