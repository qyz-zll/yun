package com.zll.server.controller;


import com.zll.server.pojo.Admin;
import com.zll.server.pojo.RespBean;
import com.zll.server.pojo.Role;
import com.zll.server.service.IAdminService;
import com.zll.server.service.IRoleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/system/admin")
public class AdminController {
    @Autowired
    private IAdminService adminService;
    @Autowired
    private IRoleService roleService;
    @ApiOperation(value = "获取所有操作员")
    @GetMapping("/")
    public List<Admin> getAllAdmins(String keywords){
        return adminService.getAllAdmins(keywords);
    }

    @ApiOperation(value = "更新操作员")
    @PutMapping("/")
    public RespBean updateAdmin(@RequestBody Admin admin){
        if (adminService.updateById(admin)){
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }
    @ApiOperation(value = "删除操作员")
    @DeleteMapping ("/{id}")
    public RespBean deleteAdmin(@PathVariable Integer id){
        if (adminService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }
    @ApiOperation(value = "获取所有角色")
    @GetMapping ("/roles")
    public List<Role> getAllRoles(){
        return roleService.list();
    }
    @ApiOperation(value = "更新操作员角色")
    @PutMapping ("/role")
    public RespBean updateAdminRole(Integer adminId,Integer[] rids){
        return adminService.updateAdminRole(adminId,rids);
    }


}
