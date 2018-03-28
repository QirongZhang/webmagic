package com.zhangqirong.webmagic.test;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

@TargetUrl("http://www.23us.so/xiaoshuo/\\w+\\.html")
@HelpUrl("http://www.23us.so/list/\\w+\\.html")
public class Demo2 {

    @ExtractBy(value = "//dl[@id='content']/dd[1]/h1/text()")
    private String novel;

   /* @ExtractBy(value = "//table/tbody/tr[1]/td[2]/text()")
    private String author;

    @ExtractBy(value = "//dl[@id='content']/dd[4]/p[2]/text()")
    private String introduction;

    @ExtractBy(value = "regex(http:\\/\\/www\\.23us\\.so/files/article/image/\\w+/\\w+/\\w+)")
    private String novelPic;*/


//    @ExtractByUrl("//div[@class='book-info']/p[@class='tag']/a[1]/text()")
//    private String author;

    /*@ExtractBy("//div[@id='readme']/tidyText()")
    private String readme;*/

    public static void main(String[] args) {
        OOSpider.create(Site.me().setSleepTime(1000)
                , new ConsolePageModelPipeline(), Demo2.class)
                .addUrl("http://www.23us.so/list/\\w+\\.html")
                .thread(5)
                .run();
    }
}
