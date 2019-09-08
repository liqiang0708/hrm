package com.liqiang.hrm.web.controller;

import com.liqiang.hrm.service.IPagesConfigService;
import com.liqiang.hrm.domain.PagesConfig;
import com.liqiang.hrm.query.PagesConfigQuery;
import com.liqiang.hrm.util.AjaxResult;
import com.liqiang.hrm.util.PageList;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagesConfig")
public class PagesConfigController {
    @Autowired
    public IPagesConfigService pagesConfigService;

    /**
    * 保存和修改公用的
    * @param pagesConfig  传递的实体
    * @return Ajax转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody PagesConfig pagesConfig){
        try {
            if(pagesConfig.getId()!=null){
                pagesConfigService.updateById(pagesConfig);
            }else{
                pagesConfigService.insert(pagesConfig);
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
            pagesConfigService.deleteById(id);
            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！"+e.getMessage());
        }
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public PagesConfig get(@PathVariable("id")Long id) {
        return pagesConfigService.selectById(id);
    }


    /**
    * 查看所有的员工信息
    * @return 列表对象
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<PagesConfig> list(){
        return pagesConfigService.selectList(null);
    }


    /**
    * 分页查询数据
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    public PageList<PagesConfig> json(@RequestBody PagesConfigQuery query){
        Page<PagesConfig> page = new Page<PagesConfig>(query.getPage(),query.getRows());
            page = pagesConfigService.selectPage(page);
            return new PageList<PagesConfig>(page.getTotal(),page.getRecords());
    }
}
