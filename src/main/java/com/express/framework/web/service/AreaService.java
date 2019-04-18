package com.express.framework.web.service;

import com.express.project.system.area.domain.Areas;
import com.express.project.system.area.domain.Cities;
import com.express.project.system.area.service.IAreasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Chenyb
 * @title: AreaService
 * @projectName Express
 * @description: TODO
 * @date 2019/4/1814:48
 */
@Service("area")
public class AreaService {

    @Autowired
    private IAreasService areasService;

     /**
     　* @description: TODO
       * @ author Chenyb
     　* @params: String cityId
     　* @return: List<Areas>
     　* @date 2019/4/18 15:29
     　*/
    public List<Areas> getAreaListByCityId(String cityId){
        Areas areas=new Areas();
        areas.setCityid(cityId);
        return areasService.selectAreasList(areas);
    }

}
