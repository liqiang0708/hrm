package com.liqiang.hrm.service;

import com.liqiang.hrm.domain.Pages;
import com.baomidou.mybatisplus.service.IService;
import com.liqiang.hrm.query.PagesQuery;
import com.liqiang.hrm.util.PageList;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liqiang
 * @since 2019-09-08
 */
public interface IPagesService extends IService<Pages> {

    PageList<Pages> selectListPage(PagesQuery query);
}
