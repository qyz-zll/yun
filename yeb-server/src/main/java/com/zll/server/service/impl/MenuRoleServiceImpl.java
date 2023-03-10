package com.zll.server.service.impl;

import com.zll.server.pojo.MenuRole;
import com.zll.server.mapper.MenuRoleMapper;
import com.zll.server.pojo.RespBean;
import com.zll.server.service.IMenuRoleService;
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
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements IMenuRoleService {

    @Override
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        return null;
    }
}
