package com.zhangqirong.webmagic.entry;

import com.zhangqirong.webmagic.model.BusChapter;
import com.zhangqirong.webmagic.pipeline.ChapterDaoPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.OOSpider;

@Component
public class ChapterEntry {

    @Qualifier("ChapterDaoPipeline")
    @Autowired
    private ChapterDaoPipeline chapterDaoPipeline;

    public void crawl() {
        OOSpider.create(Site.me()
                .setSleepTime(100), chapterDaoPipeline, BusChapter.class)
                .addUrl("https://www.208xs.com")
                .thread(10)
                .run();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");
        final ChapterEntry webmagicEntry = applicationContext.getBean(ChapterEntry.class);
        webmagicEntry.crawl();
    }
}
