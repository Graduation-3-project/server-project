package gp.lcw.sd.by.g3p.extension.domain;

import gp.lcw.sd.by.g3p.base.dao.GenericDao;
import gp.lcw.sd.by.g3p.extension.dao.administrator;

public interface administratorDaoOperate extends GenericDao<administrator,Long> {
   // administrator findByAccount(String account);
    public administrator findByAccount(String account);
}
