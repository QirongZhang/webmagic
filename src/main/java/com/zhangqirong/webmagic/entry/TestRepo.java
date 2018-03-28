package com.zhangqirong.webmagic.entry;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

@TargetUrl("https://www.208xs.com/dingdian/\\w+/")
@HelpUrl("https://www.208xs.com/dingdian/\\w+/")

//https://www.208xs.com/dingdian/18_18569/
//https://www.208xs.com/dingdian/18_18569/n5698142.html
//https://www.208xs.com/dingdian/18_18569/n5698143.html

public class TestRepo {

    /**
     * 小说名称
     */
    @ExtractBy(
            value = "//h1/text()"
//            notNull = true
    )
    private String novelName;

    @ExtractBy(
            value = "//h3[1]/text()"
//            notNull = true
    )
    private String author;

    /**
     * 简介
     */
    @ExtractBy(
            value = "//div[@id='intro']/html()"
//            notNull = true
    )
    private String introduction;

    /**
     * 图片地址
     */
    @ExtractBy(
//            https:\\/\\/www\\.208xs\\.com/files/article/image/\\w+/\\w+/(\\w+).jpg
            value = "regex(https:\\/\\/www\\.208xs\\.com/files/article/image/\\w+/\\w+/(\\w+)\\.jpg)"
//            notNull = true
    )
    private String novelPic;

    /**
     * 状态
     */
    @ExtractBy(
            value = "//div[@class='info']/p[3]/text()"
//            notNull = true
    )
    private String state;


    /**
     * 创建时间
     */
    @ExtractBy(
            value = "//div[@class='info']/p[1]/text()"
//            notNull = true
    )
    private String updateTime;

    @ExtractBy(
            value = "//div[@class='info']/p[2]/text()"
//            notNull = true
    )
    private String category;

    public static void main(String[] args) {
        OOSpider.create(Site.me().setSleepTime(1000)
                , new ConsolePageModelPipeline(), TestRepo.class)
                .addUrl("https://www.208xs.com").thread(5).run();
    }
}