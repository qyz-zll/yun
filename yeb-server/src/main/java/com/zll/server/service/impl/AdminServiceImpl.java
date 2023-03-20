package com.zll.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zll.server.config.security.component.JwtTokenUtil;
import com.zll.server.mapper.RoleMapper;
import com.zll.server.pojo.Admin;
import com.zll.server.mapper.AdminMapper;
import com.zll.server.pojo.Menu;
import com.zll.server.pojo.RespBean;
import com.zll.server.pojo.Role;
import com.zll.server.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 张磊磊
 * @since 2022-11-25
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private RoleMapper roleMapper;


    private List<com.zll.server.pojo.Role> Role;

    //    @SneakyThrows
    @SneakyThrows
    @Override
    public RespBean login(String username, String password, String code, HttpServletRequest request) {
//        # 运行redis


        String captcha  = (String) request.getSession().getAttribute("code");
        System.out.println(captcha);
        System.out.println(code + "当前验证码为" + captcha);
        if (captcha == null || !captcha.equalsIgnoreCase(code)){
            return RespBean.error("验证码输入错误，请重新输入");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        if(null==userDetails || !password.equals(userDetails.getPassword())){
            return  RespBean.error("用户名密码不正确");
        }
        if (!userDetails.isEnabled()){
            return RespBean.error("账号被禁用");
        }
        UsernamePasswordAuthenticationToken authenticationToken = new
                UsernamePasswordAuthenticationToken(userDetails,
                null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);


        String token = jwtTokenUtil.generateToken(userDetails);
        System.out.println(username + "这是用户名");


        Map<String,String>tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        System.out.println(tokenMap);
        return RespBean.success("登录成功",tokenMap);
    }

    @Override
    public Admin getAdminByUserName(String username) {
        return adminMapper.selectOne(new QueryWrapper<Admin>()
                .eq("username",username)
                .eq("enabled",true));
    }

    @Override
    public List<Role> getRoles(Integer adminId) {
        return roleMapper.getRoles(adminId);
    }



    @Override
    public List<Admin> getAllAdmins(String keywords) {
        return null;
    }


}
