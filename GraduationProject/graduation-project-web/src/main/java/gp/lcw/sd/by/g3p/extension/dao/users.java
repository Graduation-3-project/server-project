package gp.lcw.sd.by.g3p.extension.dao;

import gp.lcw.sd.by.g3p.base.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "user_info")
@Entity
public class users extends BaseEntity {

    @Column
    String user_Name;//姓名

    @Column
    String user_gender;//性别

    @Column
    String user_Age;//年龄

    @Column
    String user_Type;//类型

    @Column
    String user_LoginFlag;//登录标志

    @Column
    String user_City;//所在城市

    @Column
    String user_tel;//电话号码就是账号

    @Column
    String user_register_code;//注册参数

    @Column
    String user_password;//密码

}
