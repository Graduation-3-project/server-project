package gp.lcw.sd.by.g3p.extension.dao;


import gp.lcw.sd.by.g3p.base.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Table(name = "newsMessage")
@Entity
public class newsMessage extends BaseEntity{


    @Column
    String newsTitle;//标题

    @Column
    String newsAuthor;//作者


    @Column
    String newsType;//类型

    @Lob
    @Basic(fetch=FetchType.LAZY)
    @Column(name = "newsContent",columnDefinition = "LONGTEXT")  //columnDefinition 赋值要大写要加上name
    String newsContent;//内容


    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "picsUrl", columnDefinition = "mediumblob")/*mediumblob一行可以存储16MB*/
    String picsUrl;//图片

    @Column
    String videosUrl;//视频

    @Column
    String topFlag;//置顶标志

    @Column
    String clickNumber;//点击数量

    @ManyToOne
    @JoinColumn(name = "news_pageId")
    news news;
}
