package com.zll.server.controller;

import com.zll.server.pojo.Admin;
import com.zll.server.pojo.ChatMsg;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;


import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @program: yeb
 * @description: 在线聊天
 * @author: 张磊磊
 * @create: 2023/3/11
 */
@Controller
@Api(value = "消息中转站",tags = "消息中转站")
public class WsController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/ws/chat")
    public void handleMsg(Authentication authentication, ChatMsg chatMsg){
        // 1.获取当前登录用户
        Admin admin = (Admin) authentication.getPrincipal();
        // 2.登录的用户名
        chatMsg.setFrom(admin.getUsername());
        // 3.显示的用户名
        chatMsg.setFormNickName(admin.getName());
        // 4.发送时间
        chatMsg.setDate(LocalDateTime.now());
        // 1.发送给谁 2.队列 3.发送的消息
        simpMessagingTemplate.convertAndSendToUser(chatMsg.getTo(), "/queue/chat", chatMsg);
        // 5.security中放行请求
    }
}
