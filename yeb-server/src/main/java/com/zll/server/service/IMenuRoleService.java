package com.zll.server.service;

import com.zll.server.pojo.MenuRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zll.server.pojo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 张磊磊
 * @since 2022-11-25
 */
public interface IMenuRoleService extends IService<MenuRole> {

    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
