package com.liqiang.hrm.web.controller;

import com.liqiang.hrm.service.IPagesService;
import com.liqiang.hrm.domain.Pages;
import com.liqiang.hrm.query.PagesQuery;
import com.liqiang.hrm.util.AjaxResult;
import com.liqiang.hrm.util.PageList;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pages")
public class PagesController {
    @Autowired
    public IPagesService pagesService;

    /**
    * 保存和修改公用的
    * @param pages  传递的实体
    * @return Ajax转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Pages pages){
        try {
            if(pages.getId()!=null){
                pagesService.updateById(pages);
            }else{
                pagesService.insert(pages);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("保存对象失败！"+e.getMessage());
        }
    }

    /**
    * 删除对象信息
    * @param id
    * @return Ajax转换结果
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id){
        try {
            pagesService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！"+e.getMessage());
        }
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Pages get(@PathVariable("id")Long id) {
        return pagesService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return 列表对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Pages> list(){
        return pagesService.selectList(null);
    }


    /**
    * 分页查询数据
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    public PageList<Pages> json(@RequestBody PagesQuery query){
        Page<Pages> page = new Page<Pages>(query.getPage(),query.getRows());
            page = pagesService.selectPage(page);
            return new PageList<Pages>(page.getTotal(),page.getRecords());
    }
}
