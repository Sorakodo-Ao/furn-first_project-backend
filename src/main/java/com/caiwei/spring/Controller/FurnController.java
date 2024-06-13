package com.caiwei.spring.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.caiwei.spring.Entities.Furn;
import com.caiwei.spring.Response.Result;
import com.caiwei.spring.Service.FurnService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/furn")
public class FurnController {
    @Resource
    private FurnService furnService;

    //添加
    @PostMapping("/save")
    public Result save(@RequestBody Furn furn) {
        log.info("Furn = {}", furn);
        furnService.save(furn);
        return Result.success();
    }

    //返回所有
    @GetMapping("/list")
    public Result list() {
        List<Furn> furnList = furnService.list();
        return Result.success(furnList);
    }

    //修改操作
    @PutMapping("/update")
    public Result update(@RequestBody Furn furn) {
        furnService.updateById(furn);
        return Result.success();
    }

    //根据id查询
    @GetMapping("/{id}")
    public Result selectById(@PathVariable("id") Integer id) {
        log.info("查询id = {}", id);
        Furn furn = furnService.getById(id);
        return Result.success(furn);
    }

    //根据id 删除数据
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        furnService.removeById(id);
        return Result.success();
    }

    //分页查询全部数据
    @GetMapping("/page")
    public Result page(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "5") Integer pageSize,
                       @RequestParam(defaultValue = "") String name) {
        IPage<Furn> page = new Page<>(pageNum, pageSize);
        IPage<Furn> furnPage = null;
        if (StringUtils.hasText(name)) {
            //name 不为空，条件分页查询
            QueryWrapper<Furn> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("name", name);
            furnPage = furnService.page(page, queryWrapper);
        } else {
            //name 为空，分页查询
            furnPage = furnService.page(page);
        }
        return Result.success(furnPage);
    }


}
