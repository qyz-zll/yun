package com.zll.server.service;

import com.zll.server.pojo.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zll.server.pojo.RespBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 张磊磊
 * @since 2022-11-25
 */
public interface IDepartmentService extends IService<Department> {

    List<Department> getAllDepartments();

    RespBean addDep(Department dep);

    RespBean deleteDep(Integer id);
}
