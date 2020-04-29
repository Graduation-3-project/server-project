package gp.lcw.sd.by.g3p.extension.dao.CommunicationSpace;

import gp.lcw.sd.by.g3p.base.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "communicationSpace_message")
public class message extends BaseEntity {


    @Column
    String messageTitle;//消息标题


    @Lob
    @Basic(fetch=FetchType.LAZY)
    @Column(name = "messageContent",columnDefinition = "LONGTEXT")  //columnDefinition 赋值要大写要加上name
    String messageContent;//消息内容

    @Column
    String message_type;//种类

    @Column
    Integer message_badPointNumber;//批评数目

    @Column
    Integer message_goodPointNumber;//点赞数目

    //@Lob
    //@Basic(fetch = FetchType.LAZY)
    //@Column(name = "picsList", columnDefinition = "mediumblob")//mediumblob一行可以存储16MB
    //String[]picsList;

    @OneToMany(cascade = CascadeType.ALL)/*,mappedBy = "messageOne"s*///单向关联
    List<messagePics>messagePicsList;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "message")
    Set<messageComment>messageCommentSet=new HashSet<messageComment>();
}
