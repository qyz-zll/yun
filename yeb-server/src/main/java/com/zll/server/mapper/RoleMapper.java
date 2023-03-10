package com.zll.server.mapper;

import com.zll.server.pojo.Role;
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
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> getRoles(Integer adminId);
}
