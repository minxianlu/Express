package com.express.framework.web.service;

import com.express.project.system.area.domain.Provinces;
import com.express.project.system.area.service.IProvincesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Chenyb
 * @title: ProvinceService
 * @projectName Express
 * @description: TODO
 * @date 2019/4/1813:45
 */
@Service("province")
public class ProvinceService {

    @Autowired
    private IProvincesService provincesService;

     /**
     　* @description: TODO
       * @ author Chenyb
     　* @params:
     　* @return: List<Provinces>
     　* @date 2019/4/18 14:47 
     　*/
    public List<Provinces> getProvinceList(){
       return provincesService.selectProvincesList(new Provinces());
    }
}
