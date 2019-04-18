package com.express.framework.web.service;

import com.express.project.system.area.domain.Cities;
import com.express.project.system.area.service.ICitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Chenyb
 * @title: CityService
 * @projectName Express
 * @description: TODO
 * @date 2019/4/1814:31
 */
@Service("city")
public class CityService {

    @Autowired
    private ICitiesService citiesService;

    /**
     　* @description: TODO
       * @author Chenyb
     　* @params:  provinceId
     　* @return: List<Cities>
     　* @date 2019/4/18 14:44
     */
    public List<Cities> getCityListByProvinceId(String provinceId){
        Cities city=new Cities();
        city.setProvinceid(provinceId);
        return citiesService.selectCitiesList(city);
    }
}
