package com.zhangqirong.webmagic.test;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class TestPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex("(https://www.qidian.com/free/all\\?chanId=\\w+&orderId=&page=1&vip=hidden&style=1&pageSize=20&siteid=1&pubflag=0&hiddenField=1)").all());
//        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
        page.putField("tags",
                page.getHtml().xpath("//div[@class='select-list']/div[@class='work-filter type-filter']/div[@class='sub-type']/tidyText()").toString());
//        if (page.getResultItems().get("name")==null){
//            //skip this page
//            page.setSkip(true);
//        }
//        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new TestPageProcessor()).addUrl("https://www.qidian.com/free/all").thread(10).run();
    }
}
