package com.bison.crawler.vo;

import com.xuxueli.crawler.annotation.PageFieldSelect;
import com.xuxueli.crawler.annotation.PageSelect;
import lombok.Data;

/**
 * @description:
 * @author: Changhai
 * @time: 2020/7/17 23:40
 */
@Data
@PageSelect(cssQuery = ".job-list")
public class BossJobListVO {

    @PageFieldSelect(cssQuery = ".job-name")
    private String jobName;

    @PageFieldSelect(cssQuery = ".job-area")
    private String jobArea;

    @PageFieldSelect(cssQuery = ".job-pub-time")
    private String jobPubTime;

    @PageFieldSelect(cssQuery = ".job-limit clearfix")
    private String jobLimit;

    @PageFieldSelect(cssQuery = ".name")
    private String companyName;
}
