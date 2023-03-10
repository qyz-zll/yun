package com.zll.server.service;

import com.zll.server.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 张磊磊
 * @since 2022-11-25
 */
public interface IMenuService extends IService<Menu> {

//     * 根据用户id查询菜单列表
//     * @return


    List<Menu> getMenusByAdminId();

    /**
     * 根据角色获取菜单列表
     */
    List<Menu> getMenusWithRole();

    List<Menu> getAllMenus();
}
