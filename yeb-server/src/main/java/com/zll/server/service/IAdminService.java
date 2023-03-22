package com.zll.server.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.zll.server.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zll.server.pojo.Menu;
import com.zll.server.pojo.RespBean;
import com.zll.server.pojo.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 张磊磊
 * @since 2022-11-25
 */
public interface IAdminService extends IService<Admin> {

    RespBean login(String username, String password, String code, HttpServletRequest request);

    Admin getAdminByUserName(String username);
//    获取roles
    List<Role> getRoles(Integer adminId);

//    获取操作员
    List<Admin> getAllAdmins(String keywords);
//    更新操作员角色
    RespBean updateAdminRole(Integer adminId, Integer[] rids);
}
