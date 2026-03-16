package com.quanxiaoha.xiaohashu.auth.controller;

import com.quanxiaoha.framework.biz.operationlog.aspect.ApiOperationlog;
import com.quanxiaoha.framework.common.response.Response;
import com.quanxiaoha.xiaohashu.auth.model.vo.user.UpdatePasswordReqVO;
import com.quanxiaoha.xiaohashu.auth.model.vo.user.UserLoginReqVO;
import com.quanxiaoha.xiaohashu.auth.service.AuthService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author: 犬小哈
 * @date: 2024/5/29 15:32
 * @version: v1.0.0
 * @description: TODO
 **/
@RestController
@Slf4j
public class AuthController {

    @Resource
    private AuthService userService;

    @PostMapping("/login")
    @ApiOperationlog (description = "用户登录/注册")
    public Response<String> loginAndRegister(@Validated @RequestBody UserLoginReqVO userLoginReqVO) {
        return userService.loginAndRegister(userLoginReqVO);
    }
    @PostMapping("/logout")
    @ApiOperationlog(description = "账号登出")
    public Response<?> logout() {
        return userService.logout();
    }
    @PostMapping("/password/update")
    @ApiOperationlog(description = "修改密码")
    public Response<?> updatePassword(@Validated @RequestBody UpdatePasswordReqVO updatePasswordReqVO) {
        return userService.updatePassword(updatePasswordReqVO);
    }



}
