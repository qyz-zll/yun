package com.zll.server.service.impl;

import com.zll.server.pojo.MailLog;
import com.zll.server.mapper.MailLogMapper;
import com.zll.server.service.IMailLogService;
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
public class MailLogServiceImpl extends ServiceImpl<MailLogMapper, MailLog> implements IMailLogService {

}
