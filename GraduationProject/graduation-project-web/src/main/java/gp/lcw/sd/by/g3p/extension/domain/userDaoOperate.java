package gp.lcw.sd.by.g3p.extension.domain;

import gp.lcw.sd.by.g3p.base.dao.GenericDao;
import gp.lcw.sd.by.g3p.extension.dao.users;

public interface userDaoOperate extends GenericDao<users,Long> {

    public users findByUserTel(String userTel);//如果在这里添加jpa依照某个属性查询的方法这个属性不能使用下划
}
