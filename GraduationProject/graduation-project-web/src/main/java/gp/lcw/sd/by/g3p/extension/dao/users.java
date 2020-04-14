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
    String userName;//姓名

    @Column
    String userGender;//性别

    @Column
    String userAge;//年龄

    @Column
    String userType;//用户类型

    @Column
    String userLoginFlag;//登录标志

    @Column
    String userCity;//所在城市

    @Column
    String userTel;//电话号码就是账号

    @Column
    String userRegisterCode;//注册验证码

    @Column
    String userPassword;//密码

    @Column
    String userProfileUrl;//用户图像

    @Column
    String userRegisterFlag;//注册标志

    @Column
    String userScreenName;//用户昵称

    @Column
    String userPowerFlag;//用户 权限标志

    @Column
    String userSetCookiFlag;//是否记住密码标志

}