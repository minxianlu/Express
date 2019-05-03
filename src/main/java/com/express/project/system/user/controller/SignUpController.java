package com.express.project.system.user.controller;

import com.express.common.constant.UserConstants;
import com.express.common.utils.StringUtils;
import com.express.framework.aspectj.lang.annotation.Log;
import com.express.framework.aspectj.lang.enums.BusinessType;
import com.express.framework.web.controller.BaseController;
import com.express.framework.web.domain.AjaxResult;
import com.express.project.system.post.service.IPostService;
import com.express.project.system.role.service.IRoleService;
import com.express.project.system.user.domain.User;
import com.express.project.system.user.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/signUp")
public class SignUpController extends BaseController {

    private String prefix = "signUp";

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPostService postService;

    /**
     * 新增保存用户
     */
    @Log(title = "用户注册", businessType = BusinessType.INSERT)
    @PostMapping("/signUpSave")
    @ResponseBody
    public AjaxResult signUpSave(User user)
    {
        user.setDeptId(UserConstants.DEPT_ID);
        user.setRoleIds(UserConstants.ROLE_IDS);
        user.setCreateBy("注册用户");

        return toAjax(userService.insertUser(user));
    }
    /**
     * 校验用户名
     */
    @PostMapping("/checkLoginNameUnique")
    @ResponseBody
    public String checkLoginNameUnique(User user)
    {
        return userService.checkLoginNameUnique(user.getLoginName());
    }

    /**
     * 校验手机号码
     */
    @PostMapping("/checkPhoneUnique")
    @ResponseBody
    public String checkPhoneUnique(User user)
    {
        return userService.checkPhoneUnique(user);
    }

    /**
     * 校验email邮箱
     */
    @PostMapping("/checkEmailUnique")
    @ResponseBody
    public String checkEmailUnique(User user)
    {
        return userService.checkEmailUnique(user);
    }



}
