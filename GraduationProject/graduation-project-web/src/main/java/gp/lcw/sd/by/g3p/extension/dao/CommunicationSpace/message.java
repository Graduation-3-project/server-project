package gp.lcw.sd.by.g3p.extension.dao.CommunicationSpace;

import gp.lcw.sd.by.g3p.base.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "communicationSpace_message")
public class message extends BaseEntity {


    @Column
    String message_title;//标题

    @Column
    String message_content;//内容

    //@Column
     //List<String> message_comment=new ArrayList<>();//评论

    @Column
    String message_type;//种类

    @Column
    String message_badPointNumber;

    @Column
    String message_goodPointNumber;



}
