package gp.lcw.sd.by.g3p.extension.dao;

import gp.lcw.sd.by.g3p.base.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Table
@Entity
public class administrator extends BaseEntity {

    @Column
    String type;

    @Column
    String account;

    @Column
    String password;

    @Column
    boolean loginFlag;

}
