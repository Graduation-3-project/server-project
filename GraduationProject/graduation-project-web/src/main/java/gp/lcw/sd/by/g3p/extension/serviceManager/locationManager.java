package gp.lcw.sd.by.g3p.extension.serviceManager;

import gp.lcw.sd.by.g3p.base.service.GenericManager;
import gp.lcw.sd.by.g3p.extension.dao.CommunicationSpace.message;
import gp.lcw.sd.by.g3p.extension.dao.location;
import gp.lcw.sd.by.g3p.extension.dao.users;

import java.util.List;

public interface locationManager  extends GenericManager<location,Long> {

    //List<message> findAllByUsers(users users);
}
