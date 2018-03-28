package com.zhangqirong.webmagic.pipeline;

import com.zhangqirong.webmagic.mapper.BusChapterMapper;
import com.zhangqirong.webmagic.mapper.BusNovelMapper;
import com.zhangqirong.webmagic.model.BusChapter;
import com.zhangqirong.webmagic.model.BusNovel;
import com.zhangqirong.webmagic.util.ChapterOrderBy;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component("ChapterDaoPipeline")
public class ChapterDaoPipeline implements PageModelPipeline<BusChapter> {

    @Resource
    private BusNovelMapper busNovelMapper;

    @Resource
    private BusChapterMapper chapterMapper;

    public void process(BusChapter chapter, Task task) {
        chapter.setChapterId(UUID.randomUUID().toString());
        String createTimeGet = chapter.getCreateTimeGet();
        Date createTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            createTime = sdf.parse(createTimeGet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        chapter.setCreateTime(createTime);

        String chapterName = chapter.getChapterName();

        long ordBy = ChapterOrderBy.chnNum2Digit(chapterName);
        if (ordBy  == 0) {
            ordBy =Long.parseLong( ChapterOrderBy.getNumbers(chapterName));
        }

        chapter.setOrdBy((int)ordBy);
        Example example = new Example(BusNovel.class);
        example.and().andEqualTo("novelName", chapter.getNovel());
        List<BusNovel> novelList = busNovelMapper.selectByExample(example);
        Integer novelId = novelList.get(0).getNovelId();
        chapter.setNovelId(novelId);
        if (novelId != null && !novelId.equals("")) {
            int insert = chapterMapper.insert(chapter);
            System.out.println("已经插入数据==================序号>>>>>" + insert + "----" + chapter.getChapterName());
        }
    }
}
