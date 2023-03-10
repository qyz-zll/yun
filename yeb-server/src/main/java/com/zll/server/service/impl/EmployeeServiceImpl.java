package com.zll.server.service.impl;

import com.zll.server.pojo.Employee;
import com.zll.server.mapper.EmployeeMapper;
import com.zll.server.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 张磊磊
 * @since 2022-11-25
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
