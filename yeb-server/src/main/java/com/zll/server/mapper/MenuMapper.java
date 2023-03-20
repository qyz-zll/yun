package com.zll.server.mapper;

import com.zll.server.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 张磊磊
 * @since 2022-11-25
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getMenusByAdminId(Integer id);


    List<Menu> getMenusWithRole();

    List<Menu> getAllMenus();
}
