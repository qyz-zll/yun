package com.zll.server.mapper;

import com.zll.server.pojo.MenuRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.security.core.parameters.P;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 张磊磊
 * @since 2022-11-25
 */
public interface MenuRoleMapper extends BaseMapper<MenuRole> {
//    void insertRecord(Integer rid, Integer mids);

    Integer insertRecord(@Param("rid") Integer rid,@Param("mids") Integer[] mids);
}
