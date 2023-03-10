package com.zll.server.config.security.component;

import com.zll.server.pojo.Menu;
import com.zll.server.pojo.Role;
import com.zll.server.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;
import java.util.Map;

//根据请求url 分析所需的角色
@Component
public class CustomFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private IMenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //获取请求的url
        String requestUrl = ((FilterInvocation)o).getRequestUrl();
        //System.out.println("requestUrl = " + requestUrl);
        //获取菜单
        List<Menu> menus = menuService.getMenusWithRole();
        //System.out.println("menus = " + menus);
        for (Menu menu : menus) {
            //判断请求的url与菜单角色是否匹配
            if (antPathMatcher.match(menu.getUrl(),requestUrl)){
                //System.out.println("menu = " + menu.getUrl());
                String[] str = menu.getRoles().stream().map(Role::getName).toArray(String[]::new);
                //System.out.println("str = " + str);
                return SecurityConfig.createList(str);
            }
        }
        //没匹配的url默认为登录即可访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
