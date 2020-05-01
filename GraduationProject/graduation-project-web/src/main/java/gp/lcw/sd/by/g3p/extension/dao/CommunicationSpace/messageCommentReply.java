package gp.lcw.sd.by.g3p.extension.dao.CommunicationSpace;


import gp.lcw.sd.by.g3p.base.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "communicationSpace_message_Comment_Reply")
public class messageCommentReply extends BaseEntity {

    @Column
    String commentPeopleName;//评论的人名

    @Column
    String replyCommentContent;//评论内容

    @Column
    Long messageFromUserId;//发表回复人的id

    @Column
    Long messageToUserId;//接收回复人的id

    @Column
    String   messageFromUserName;//发表回复人的昵称

    @Column
    String messageToUserName;//接收回复人的昵称

    @Column
    Long messageId;

    @Column
    Long messageCommentId;
    //@ManyToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "id",insertable = false,updatable = false)
    //messageComment messageComment;
}
