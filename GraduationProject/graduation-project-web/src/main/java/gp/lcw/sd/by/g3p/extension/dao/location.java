package gp.lcw.sd.by.g3p.extension.dao;

import gp.lcw.sd.by.g3p.base.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table
public class location extends BaseEntity {


    @Column
    public String region;//所在省

    @Column
    public String city;//所在市

    @Column
    public String country;//所在国家


}
