package gp.lcw.sd.by.g3p.extension.dao;

import gp.lcw.sd.by.g3p.base.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table
public class notice extends BaseEntity {


    @Column
    public String noticeContent;//通知内容

    @Column
    public  String noticeTitle;

    @Column
    public  String topFlag;

}
