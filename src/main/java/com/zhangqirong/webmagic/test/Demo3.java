package com.zhangqirong.webmagic.test;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class Demo3 implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    public void process(Page page) {
//        http://www.23us.so/files/article/html/17/17928/8843205.html
//        http://www.23us.so/files/article/html/17/17928/8843206.html

//        http://www.23us.so/files/article/html/2/2739/1336285.html

        page.addTargetRequests(page.getHtml().links().regex("(http://www\\.23us\\.so/\\w+/\\w+\\.html)").all());
//        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
//        page.putField("content", page.getHtml().xpath("//div[@class='body novel']/ul[@class='chapterlist']/li/span/html()").toString());

        page.putField("title", page.getHtml().xpath("//dl[@id='content']/dd[1]/h1/text()").toString());
        page.putField("bigCategoryId", page.getHtml().xpath("//table/tbody/tr[1]/td[1]/a/text()").toString());
        page.putField("author", page.getHtml().xpath("//table/tbody/tr[1]/td[2]/text()").toString());
        page.putField("introduction", page.getHtml().xpath("//dl[@id='content']/dd[4]/p[2]/text()").toString());
//        http://www.23us.so/files/article/image/9/9495/9495s.jpg
//        http://www.23us.so/files/article/image/21/21250/21250s.jpg
//        page.putField("introduction", page.getHtml().xpath("//dl[@id='content']/dd[2]/div[1]/a/@src/html()").toString());
//        http://www.23us.so/files/article/image/18/18671/18671s.jpg
        page.putField("novelPic", page.getUrl().regex("http:\\/\\/www\\.23us\\.so/files/article/image/\\w+/\\w+/\\w+").toString());
//        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new Demo3()).addUrl("http://www.23us.so/").thread(5).run();
    }
}

