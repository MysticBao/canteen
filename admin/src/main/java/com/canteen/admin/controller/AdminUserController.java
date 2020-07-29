package com.canteen.admin.controller;

import com.canteen.admin.controller.request.AdminUserParam;
import com.canteen.admin.model.AdminUser;
import com.canteen.admin.service.AdminUserService;
import com.canteen.common.exception.CanteenServiceException;
import com.canteen.common.result.CommonResult;
import com.canteen.common.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<AdminUser> register(@Valid @NotNull AdminUserParam adminUserParam, BindingResult bindingResult) throws CanteenServiceException {
        // return error message first if validation failed
        if (bindingResult.hasErrors()) {
            return CommonResult.fail(ResultCode.BAD_REQUEST, bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        AdminUser adminUser = AdminUser.builder().name(adminUserParam.getUsername())
                .password(adminUserParam.getPassword()).build();
        adminUser = adminUserService.register(adminUser);
        if (adminUser == null) {
            return CommonResult.fail(ResultCode.BAD_REQUEST);
        }
        return CommonResult.success(adminUser);
    }
}
