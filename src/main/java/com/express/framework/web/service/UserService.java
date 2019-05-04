package com.express.framework.web.service;


import com.express.common.utils.bean.BeanUtils;
import com.express.common.utils.security.ShiroUtils;
import com.express.project.system.role.domain.Role;
import com.express.project.system.user.domain.User;
import com.express.project.system.user.service.IUserService;
import org.apache.poi.ss.usermodel.IgnoredErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userServiceForHtml")
public class UserService {
    @Autowired
    private IUserService userService;

    public String[] getRoleKey(){
        String loginName= ShiroUtils.getLoginName();
        User user=userService.selectUserByLoginName(loginName);
        List<Role> roleList=user.getRoles();
        if(BeanUtils.isEmpty(roleList)){
            return new String[1];
        }
        String[] result=new String[roleList.size()];
        for (int i=0;i<roleList.size();i++){
            result[i]=roleList.get(i).getRoleKey();
        }
        return result;



    }

}
