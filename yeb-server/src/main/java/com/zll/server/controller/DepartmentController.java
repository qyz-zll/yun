package com.zll.server.controller;


import com.zll.server.pojo.Department;
import com.zll.server.pojo.RespBean;
import com.zll.server.service.IDepartmentService;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("system/basic/department")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

    @ApiOperation("获取所有部门")
    @GetMapping("/")
    public List<Department>getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @ApiOperation(value = "添加部门")
    @PostMapping("/")
    public RespBean addDep(@RequestBody Department dep){
        return departmentService.addDep(dep);
    }

    @ApiOperation(value = "刪除部门")
    @PostMapping("/")
    public RespBean deleteDep(@RequestBody Department dep){
        return departmentService.addDep(dep);
    }
}
