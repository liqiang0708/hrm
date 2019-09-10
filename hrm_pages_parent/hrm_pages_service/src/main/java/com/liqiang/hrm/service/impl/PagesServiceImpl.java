package com.liqiang.hrm.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.liqiang.hrm.domain.Pages;
import com.liqiang.hrm.mapper.PagesMapper;
import com.liqiang.hrm.query.PagesQuery;
import com.liqiang.hrm.service.IPagesService;
import com.liqiang.hrm.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liqiang
 * @since 2019-09-08
 */
@Service
public class PagesServiceImpl extends ServiceImpl<PagesMapper, Pages> implements IPagesService {

    @Autowired
    private PagesMapper pagesMapper;
    @Override
    public PageList<Pages> selectListPage(PagesQuery query) {
        //page
        Page<Pages> page = new Page<>(query.getPage(), query.getRows());
        //list
        //System.out.println("Total:"+page.getTotal());  //分页成功了还是  0  ...
        //System.out.println("Pages:"+page.getPages()); // 0
        List<Pages> rows = pagesMapper.loadListPage(page, query);
        return new PageList<>(page.getTotal(),rows);
    }
}
