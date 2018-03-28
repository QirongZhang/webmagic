package com.zhangqirong.webmagic.test;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

@TargetUrl("https://book.qidian.com/info/\\w+")
@HelpUrl("https://www.qidian.com/free/all")
public class Test {

    @ExtractBy(value = "//div[@class='book-info']/p[@class='tag']/a[1]/text()")
    private String name;

    @ExtractBy(value = "//div[@class='book-info']/p[@class='tag']/a[2]/text()")
    private String author;

//    @ExtractByUrl("//div[@class='book-info']/p[@class='tag']/a[1]/text()")
//    private String author;

    /*@ExtractBy("//div[@id='readme']/tidyText()")
    private String readme;*/

    public static void main(String[] args) {
        OOSpider.create(Site.me().setSleepTime(1000)
                , new ConsolePageModelPipeline(), Test.class)
                .addUrl("https://www.qidian.com/free/all")
                .thread(5)
                .run();
    }
}
