package com.zll.server.mapper;

import com.zll.server.pojo.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zll.server.pojo.Menu;
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
public interface AdminMapper extends BaseMapper<Admin> {


    List<Admin> getAllAdmins(@Param("id") Integer id,@Param("keywords") String keywords);
}
