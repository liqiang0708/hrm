package com.liqiang.hrm.client;

import com.liqiang.hrm.domain.PagesConfig;
import com.liqiang.hrm.query.PagesConfigQuery;
import com.liqiang.hrm.util.AjaxResult;
import com.liqiang.hrm.util.PageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "hrm-pages",configuration = FeignClientsConfiguration.class,
        fallbackFactory = PagesConfigClientHystrixFallbackFactory.class)
@RequestMapping("/pagesConfig")
public interface PagesConfigClient {
    /**
     * 保存和修改公用的
     * @param pagesConfig  传递的实体
     * @return Ajax转换结果
     */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    AjaxResult save(PagesConfig pagesConfig);

    /**
     * 删除对象信息
     * @param id
     * @return Ajax转换结果
     */
    @RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
    AjaxResult delete(@PathVariable("id") Integer id);

    //获取用户
    @RequestMapping("/{id}")
    PagesConfig get(@RequestParam(value="id",required=true) Long id);


    /**
     * 查看所有 信息
     * @return  列表对象
     */
    @RequestMapping("/list")
    public List<PagesConfig> list();

    /**
     * 分页查询数据
     * @param query 查询对象
     * @return PageList 分页对象
     */
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    PageList<PagesConfig> json(@RequestBody PagesConfigQuery query);
}
