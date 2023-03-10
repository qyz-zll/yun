package com.zll.server.service.impl;

import com.zll.server.pojo.Oplog;
import com.zll.server.mapper.OplogMapper;
import com.zll.server.service.IOplogService;
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
public class OplogServiceImpl extends ServiceImpl<OplogMapper, Oplog> implements IOplogService {

}
