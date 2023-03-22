package com.zll.server.mapper;

import com.zll.server.pojo.AdminRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zll.server.pojo.RespBean;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 张磊磊
 * @since 2022-11-25
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {
//    更新操作员角色
        Integer addAdminRole(@Param("adminId") Integer adminId, @Param("rids") Integer[] rids);
}
