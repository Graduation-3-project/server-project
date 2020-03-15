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
@Table(name = "statistical_data" )
public class statisticalData extends BaseEntity {

    /*
    * 总的数据统计
    * */


    @Column
    String cityNumber;//城市数量

    @Column
    String manNumber;//男性数量

    @Column
    String womanNumber;//女性数量

    @Column
    String manProportion;//男性占比

    @Column
    String womanProportion;//女性占比




    @Column
    String everyCityNumber;//每个城市数量




}
