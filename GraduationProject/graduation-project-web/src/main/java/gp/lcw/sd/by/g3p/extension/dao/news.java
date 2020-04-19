package gp.lcw.sd.by.g3p.extension.dao;

import gp.lcw.sd.by.g3p.base.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "news")
@Setter
@Getter
public class news  extends BaseEntity{
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long pageId;

    @Column
     String newsPageVideoUrl;

   // @Column
    //ArrayList<String> picsNewsMsg = new ArrayList<String>();//广告信息

    @Column
    String picsMsg;//图片轮播图

    boolean picsMsgTop;//图片置顶

    @Column
    String specialNotice;//特殊通告

    @Column
    boolean specialNoticeTopFlag;//特殊通告置顶


    //@Column
    //ArrayList<String> specialNotice = new ArrayList<String>();//特殊通告

    //  Set<String>picsNewsMsg=new HashSet<String>();
    @OneToMany(mappedBy = "news")
    Set<newsMessage>newsMessageSet=new HashSet<newsMessage>();
}