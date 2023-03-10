package com.zll.server.controller;


import com.zll.server.pojo.Joblevel;
import com.zll.server.pojo.RespBean;
import com.zll.server.service.IJoblevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LHC
 * @since 2021-06-25
 */
@Api(value = "职称管理",tags = "职称管理")
@RestController
@RequestMapping("/system/basic/joblevel")
public class JoblevelController {

    @Autowired
    IJoblevelService joblevelService;

    @ApiOperation(value = "职称列表")
    @GetMapping("/")
    public List<Joblevel> getAllJoblevels(){
        return joblevelService.list();
    }

    @ApiOperation(value = "添加职称")
    @PostMapping("/")
    public RespBean addJoblevel(@RequestBody Joblevel joblevel){
        joblevel.setCreateDate(LocalDateTime.now());
        if (joblevelService.save(joblevel)){
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @ApiOperation(value = "修改职称")
    @PutMapping("/")
    public RespBean updateJoblevel(@RequestBody Joblevel joblevel){
        if (joblevelService.updateById(joblevel)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @ApiOperation(value = "删除职称")
    @DeleteMapping("/{id}")
    public RespBean deleteJoblevel(@PathVariable Integer id) {
        if (joblevelService.removeById(id)) {
        return RespBean.success("删除成功！");
    }
    return RespBean.error("删除成功");
    }

    @ApiOperation("批量删除职称")
    @DeleteMapping("/")
    public RespBean deleteJobLevelsByIds(Integer[] ids){
        if(joblevelService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("删除成功");
        }

        return RespBean.error("删除成功");
    }


}
