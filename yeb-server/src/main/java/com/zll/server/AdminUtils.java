package com.zll.server;

import com.zll.server.pojo.Admin;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @program: yeb
 * @description: 操作员工具类
 * @author: 张磊磊
 * @create: 2021-07-19 16:06
 */
public class AdminUtils {

    /**
     * 获取当前登录操作员
     *
     * @return
     */
    public static Admin getCurrentAdmin() {
        return (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
