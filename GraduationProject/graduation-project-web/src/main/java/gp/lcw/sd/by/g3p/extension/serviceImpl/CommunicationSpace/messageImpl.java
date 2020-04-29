package gp.lcw.sd.by.g3p.extension.serviceImpl.CommunicationSpace;

import gp.lcw.sd.by.g3p.base.service.impl.GenericManagerImpl;
import gp.lcw.sd.by.g3p.extension.dao.CommunicationSpace.message;
import gp.lcw.sd.by.g3p.extension.domain.CommunicationSpace.messageDaoOperate;
import gp.lcw.sd.by.g3p.extension.serviceManager.CommunicationSpace.messageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
@Service
@Transactional
public class messageImpl extends GenericManagerImpl<message,Long> implements messageManager{

  messageDaoOperate messageDaoOperate;
  @Autowired
    public void setMessageDaoOperate(messageDaoOperate messageDaoOperate){
      this.messageDaoOperate=messageDaoOperate;
      this.dao=this.messageDaoOperate;
  }

}
