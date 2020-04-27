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
    String message_title;//消息标题

    @Column
    String message_content;//消息内容


    @Column
    String message_type;//种类

    @Column
    Integer message_badPointNumber;//批评数目

    @Column
    Integer message_goodPointNumber;//点赞数目

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "picsUrl", columnDefinition = "mediumblob")/*mediumblob一行可以存储16MB*/
    List<String>picsList;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "message")
    Set<messageComment>messageCommentSet=new HashSet<messageComment>();
}
