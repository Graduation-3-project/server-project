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
@Table(name = "cityDistributionMsg")
public class cityDistributionMsg extends BaseEntity {

    /*
    * 每个城市的分布情况信息统计
    * */

    @Column
    String cityName;

    @Column
    String manNumber;

    @Column
    String womanNumber;

    @Column
    String manProportion;

    @Column
    String womanProportion;


}
