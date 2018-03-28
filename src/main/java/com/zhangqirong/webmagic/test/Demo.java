package com.zhangqirong.webmagic.test;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

@TargetUrl("https://read.qidian.com/chapter/\\w+/\\w+")
@HelpUrl("https://book.qidian.com/info/\\w+#Catalog")
public class Demo {

//    https://read.qidian.com/chapter/ORlSeSgZ6E_MQzCecGvf7A2/atYOCLHSg35Ms5iq0oQwLQ2
//    https://read.qidian.com/chapter/ORlSeSgZ6E_MQzCecGvf7A2/tSuREBNwaBdOBDFlr9quQA2

//    https://read.qidian.com/chapter/YW-XtYincOfVl9ByXxZ_TQ2/3I3yS8w3Sc9Ms5iq0oQwLQ2
//    https://read.qidian.com/chapter/YW-XtYincOfVl9ByXxZ_TQ2/ynmR0e8EozO2uJcMpdsVgA2

//    https://book.qidian.com/info/1010566688#Catalog
//    https://book.qidian.com/info/1010734492#Catalog

    @ExtractBy(value = "//div[@class='info fl']/a[1]/text()")
    private String novel;

    @ExtractBy(value = "//h3[@class='j_chapterName']/text()")
    private String chapterName;

    @ExtractBy(value = "//div[@class='read-content j_readContent']/html()")
    private String chapterContent;

    @ExtractBy(value = "//span[@class='j_chapterWordCut']/text()")
    private String wordCount;

    @ExtractBy(value = "//span[@class='j_updateTime']/text()")
    private String createTime;

    @ExtractBy(value = "//div[@class='info fl']/a[2]/text()")
    private String createBy;

//    @ExtractByUrl("//div[@class='book-info']/p[@class='tag']/a[1]/text()")
//    private String author;

    /*@ExtractBy("//div[@id='readme']/tidyText()")
    private String readme;*/

    public static void main(String[] args) {
        OOSpider.create(Site.me().setSleepTime(1000)
                , new ConsolePageModelPipeline(), Demo.class)
                .addUrl("https://www.qidian.com")
                .thread(5)
                .run();
    }
}
