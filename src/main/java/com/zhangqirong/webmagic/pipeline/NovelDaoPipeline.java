package com.zhangqirong.webmagic.pipeline;

import com.zhangqirong.webmagic.mapper.BusCategoryMapper;
import com.zhangqirong.webmagic.mapper.BusNovelMapper;
import com.zhangqirong.webmagic.model.BusCategory;
import com.zhangqirong.webmagic.model.BusNovel;
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

@Component("NovelDaoPipeline")
public class NovelDaoPipeline implements PageModelPipeline<BusNovel> {

    @Resource
    private BusNovelMapper busNovelMapper;

    @Resource
    private BusCategoryMapper busCategoryMapper;

    public void process(BusNovel busNovel, Task task) {
//        busNovel.setNovelId(UUID.randomUUID().toString());
        String updateTime = busNovel.getUpdateTimeGet();
        updateTime = updateTime.substring(5, updateTime.length());

        Date createTime = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            createTime = sdf.parse(updateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        busNovel.setCreateTime(createTime);
        //状态
        String state = busNovel.getState();
        state = state.substring(5, state.length());
        busNovel.setState(state);

        //作者
        String author = busNovel.getAuthor();
        author = author.substring(3, author.length());
        busNovel.setAuthor(author);

        //类别
        String category = busNovel.getCategory();
        category = category.substring(5, category.length());

        Example example = new Example(BusCategory.class);
        example.and().andEqualTo("categoryName", category);
        List<BusCategory> categoryList = busCategoryMapper.selectByExample(example);
        Integer categoryId = categoryList.get(0).getCategoryId();
        busNovel.setCategoryId(categoryId);

//        busNovel.setCreateBy("zhangqirong");
//        busNovel.setUpdateBy("zhangqirong");

        int insert = busNovelMapper.insert(busNovel);
        System.out.println("已经插入数据==================序号》》》》" + insert + "hhhh");
    }
}
