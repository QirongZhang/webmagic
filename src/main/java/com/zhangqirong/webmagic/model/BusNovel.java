package com.zhangqirong.webmagic.model;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

import java.util.Date;
import javax.persistence.*;

@TargetUrl("https://www.208xs.com/dingdian/\\w+/")
@HelpUrl("https://www.208xs.com/dingdian/\\w+/")
@Table(name = "bus_novel")
public class BusNovel {
    /**
     * 小说编码
     */
    @Id
    @Column(name = "novel_id")
    private Integer novelId;

    /**
     * 小说名称
     */
    @ExtractBy(
            value = "//h1/text()"
//            notNull = true
    )
    @Column(name = "novel_name")
    private String novelName;

    @ExtractBy(
            value = "//h3[1]/text()"
//            notNull = true
    )
    private String author;

    /**
     * 简介
     */
    @ExtractBy(
            value = "//div[@id='intro']/html()"
//            notNull = true
    )
    private String introduction;

    /**
     * 图片地址
     */
    @ExtractBy(
//            https:\\/\\/www\\.208xs\\.com/files/article/image/\\w+/\\w+/(\\w+).jpg
            value = "regex(https:\\/\\/www\\.208xs\\.com/files/article/image/\\w+/\\w+/(\\w+)\\.jpg)"
//            notNull = true
    )
    @Column(name = "novel_pic")
    private String novelPic;

    /**
     * 点击量
     */
    @Column(name = "click_rate")
    private Integer clickRate;

    /**
     * 状态
     */
    @ExtractBy(
            value = "//div[@class='info']/p[3]/text()"
//            notNull = true
    )
    private String state;

    /**
     * 类别编码
     */
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
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


    @Transient
    @ExtractBy(
            value = "//div[@class='info']/p[1]/text()"
//            notNull = true
    )
    private String updateTimeGet;

    @Transient
    @ExtractBy(
            value = "//div[@class='info']/p[2]/text()"
//            notNull = true
    )
    private String category;

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
    public void setNovelId(int novelId) {
        this.novelId = novelId;
    }

    /**
     * 获取小说名称
     *
     * @return novel_name - 小说名称
     */
    public String getNovelName() {
        return novelName;
    }

    /**
     * 设置小说名称
     *
     * @param novelName 小说名称
     */
    public void setNovelName(String novelName) {
        this.novelName = novelName;
    }

    /**
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取简介
     *
     * @return introduction - 简介
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 设置简介
     *
     * @param introduction 简介
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * 获取图片地址
     *
     * @return novel_pic - 图片地址
     */
    public String getNovelPic() {
        return novelPic;
    }

    /**
     * 设置图片地址
     *
     * @param novelPic 图片地址
     */
    public void setNovelPic(String novelPic) {
        this.novelPic = novelPic;
    }

    /**
     * 获取点击量
     *
     * @return click_rate - 点击量
     */
    public Integer getClickRate() {
        return clickRate;
    }

    /**
     * 设置点击量
     *
     * @param clickRate 点击量
     */
    public void setClickRate(Integer clickRate) {
        this.clickRate = clickRate;
    }

    /**
     * 获取状态
     *
     * @return state - 状态
     */
    public String getState() {
        return state;
    }

    /**
     * 设置状态
     *
     * @param state 状态
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取类别编码
     *
     * @return category_id - 类别编码
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置类别编码
     *
     * @param categoryId 类别编码
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
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

    public String getUpdateTimeGet() {
        return updateTimeGet;
    }

    public void setUpdateTimeGet(String updateTimeGet) {
        this.updateTimeGet = updateTimeGet;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}