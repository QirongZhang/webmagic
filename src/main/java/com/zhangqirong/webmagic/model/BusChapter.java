package com.zhangqirong.webmagic.model;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

import java.util.Date;
import javax.persistence.*;

@TargetUrl("https://www.208xs.com/dingdian/\\w+/(\\w+).html")
@HelpUrl("https://www.208xs.com/dingdian/\\w+/")
@Table(name = "bus_chapter")
public class BusChapter {
    /**
     * 章节编码
     */
    @Id
    @Column(name = "chapter_id")
    private String chapterId;


    @ExtractBy(
            value = "//div[@class='data']/span[2]/a[1]/text()"
//            notNull = true
    )
    @Transient
    private String novel;


    /**
     * 小说编码
     */
    @Column(name = "novel_id")
    private Integer novelId;

    /**
     * 章节名
     */
    @ExtractBy(
            value = "//h1[1]/text()"
//            notNull = true
    )
    @Column(name = "chapter_name")
    private String chapterName;

    /**
     * 字数
     */
    @ExtractBy(
            value = "//div[@class='data']/span[5]/text()"
//            notNull = true
    )
    @Column(name = "word_count")
    private Integer wordCount;

    /**
     * 排序字段
     */
    @Column(name = "ord_by")
    private Integer ordBy;

    /**
     * 创建者
     */
    @ExtractBy(
            value = "//div[@class='data']/span[1]/text()"
//            notNull = true
    )
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 删除标记
     */
    @Column(name = "del_flag")
    private String delFlag;

    /**
     * 章节内容
     */
    @ExtractBy(
            value = "//div[@id='book_text']/html()",
            notNull = true
    )
    @Column(name = "chapter_content")
    private String chapterContent;

    @ExtractBy(
            value = "//div[@class='data']/span[4]/text()"
//            notNull = true
    )
    @Transient
    private String createTimeGet;

    /**
     * 获取章节编码
     *
     * @return chapter_id - 章节编码
     */
    public String getChapterId() {
        return chapterId;
    }

    /**
     * 设置章节编码
     *
     * @param chapterId 章节编码
     */
    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    /**
     * 获取小说编码
     *
     * @return novel_id - 小说编码
     */
    public Integer getNovelId() {
        return novelId;
    }

    /**
     * 设置小说编码
     *
     * @param novelId 小说编码
     */
    public void setNovelId(Integer novelId) {
        this.novelId = novelId;
    }

    /**
     * 获取章节名
     *
     * @return chapter_name - 章节名
     */
    public String getChapterName() {
        return chapterName;
    }

    /**
     * 设置章节名
     *
     * @param chapterName 章节名
     */
    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    /**
     * 获取字数
     *
     * @return word_count - 字数
     */
    public Integer getWordCount() {
        return wordCount;
    }

    /**
     * 设置字数
     *
     * @param wordCount 字数
     */
    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改者
     *
     * @return update_by - 修改者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置修改者
     *
     * @param updateBy 修改者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取备注
     *
     * @return remarks - 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取删除标记
     *
     * @return del_flag - 删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     *
     * @param delFlag 删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取章节内容
     *
     * @return chapter_content - 章节内容
     */
    public String getChapterContent() {
        return chapterContent;
    }

    /**
     * 设置章节内容
     *
     * @param chapterContent 章节内容
     */
    public void setChapterContent(String chapterContent) {
        this.chapterContent = chapterContent;
    }

    public String getCreateTimeGet() {
        return createTimeGet;
    }

    public void setCreateTimeGet(String createTimeGet) {
        this.createTimeGet = createTimeGet;
    }

    public String getNovel() {
        return novel;
    }

    public void setNovel(String novel) {
        this.novel = novel;
    }

    public Integer getOrdBy() {
        return ordBy;
    }

    public void setOrdBy(Integer ordBy) {
        this.ordBy = ordBy;
    }
}