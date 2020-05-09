package gp.lcw.sd.by.g3p.extension.dao.CommunicationSpace;

import gp.lcw.sd.by.g3p.base.domain.BaseEntity;

import javax.persistence.Column;
import java.util.Date;

public class userAactivity extends BaseEntity {

    @Column
    String activityName;

    @Column
    String activityContent;

    @Column
    String activityPlace;

    @Column
    String activityTime;


}
