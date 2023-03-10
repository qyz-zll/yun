package com.zll.server.controller;


import com.zll.server.service.IAdminService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.zll.server.pojo.Menu;
import com.zll.server.service.IMenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 张磊磊
 * @since 2022-11-25
 */



@RestController
@RequestMapping("/system/cfg")
public class MenuController {

    @Resource
    private IMenuService menuService;

    @ApiOperation(value = "查询admin菜单列表")
    @GetMapping("/menu")
    public List<Menu> getMenuByAdminId(){
        return menuService.getMenusByAdminId();
    }
}

