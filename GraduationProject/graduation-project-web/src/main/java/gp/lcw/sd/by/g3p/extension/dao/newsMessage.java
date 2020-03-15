package gp.lcw.sd.by.g3p.extension.dao;


import gp.lcw.sd.by.g3p.base.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@Table(name = "newsMessage")
@Entity
public class newsMessage extends BaseEntity {

    @Column
    String newsTitle;//标题


    @Column
    String newsAuthor;//作者

    @Column
    String newsType;//类型

    @Column
    String newsContent;//内容

    @Column
    String picsUrl;//图片

    @Column
    String videosUrl;//视频

    @Column
    String topFlag;//置顶标志

    @Column
    String clickNumber;//点击数量

}
