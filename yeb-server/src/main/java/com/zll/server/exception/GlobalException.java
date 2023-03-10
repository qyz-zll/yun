package com.zll.server.exception;

import com.zll.server.pojo.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

//全局异常处理
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(SQLException.class)
    public RespBean mySqlException(SQLException e){
        if (e instanceof SQLIntegrityConstraintViolationException){
            return RespBean.error("该数据有关联数据，删你妈呢！");
        }
        return RespBean.error("这是数据库出问题了，去看看");
    }
}
