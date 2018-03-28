package com.zhangqirong.webmagic.entry;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.example.GithubRepo;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.processor.PageProcessor;

public class NovelRepo implements PageProcessor{

    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    public void process(Page page) {

    }

    public Site getSite() {
        return site;
    }

   /* public static void main(String[] args) {
        OOSpider.create(Site.me().setSleepTime(1000), new ConsolePageModelPipeline(), NovelModel.class)
                .addUrl("https://www.x23us.com/html/64/")
                .thread(5)
                .run();
    }*/

    public static void main(String[] args) {
        OOSpider.create(Site.me().setSleepTime(1000), new ConsolePageModelPipeline(), GithubRepo.class)
                .addUrl("https://www.x23us.com/html/64/")
                .thread(5)
                .run();
    }
}
