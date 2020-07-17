package com.bison.crawler;

import com.bison.crawler.vo.BossJobListVO;
import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.parser.PageParser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CrawlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrawlerApplication.class, args);
        getBossJobList();
    }

    public static void getBossJobList(){
        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls("https://www.zhipin.com/c101280100/?page=1&ka=page-1")
                //.setWhiteUrlRegexs("https://www.zhipin.com/c101280100/?page=\\\\b[1-2]&ka=page-\\\\b[1-2]")
                .setThreadCount(3)
                .setPageParser(new PageParser<BossJobListVO>() {
                    @Override
                    public void parse(Document html, Element pageVoElement, BossJobListVO pageVo) {
                        // 解析封装 PageVo 对象
                        String pageUrl = html.baseUri();
                        System.out.println(pageUrl + "：" + pageVo.toString());
                    }
                })
                .build();

        System.out.println("start");
        crawler.start(true);
        System.out.println("end");
    }

}
