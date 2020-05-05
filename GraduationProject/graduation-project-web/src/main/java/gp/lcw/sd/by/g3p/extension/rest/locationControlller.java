package gp.lcw.sd.by.g3p.extension.rest;

import gp.lcw.sd.by.g3p.base.rest.GenericController;
import gp.lcw.sd.by.g3p.extension.dao.location;
import gp.lcw.sd.by.g3p.extension.domain.locationDaoOperate;
import gp.lcw.sd.by.g3p.extension.serviceManager.locationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/locatin")
public class locationControlller extends GenericController<location,Long, locationManager> {

    @Autowired
    locationDaoOperate locationDaoOperate;



    @GetMapping("/findAll")
    @ResponseBody
    public List<location>locationList(){
        List<location>locationList=locationDaoOperate.findAll();
        return  locationList;
    }



    //public location location=new location();
/*

    public void setLocation(location location){
        this.location =location;
    }
    public void add(){
        locationDaoOperate.save(this.location);
    }
*/



}
