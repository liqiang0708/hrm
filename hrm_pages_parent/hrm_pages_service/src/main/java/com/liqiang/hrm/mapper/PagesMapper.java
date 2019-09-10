package com.liqiang.hrm.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.liqiang.hrm.domain.Pages;
import com.liqiang.hrm.query.PagesQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liqiang
 * @since 2019-09-08
 */
public interface PagesMapper extends BaseMapper<Pages> {

    List<Pages> loadListPage(Page<Pages> page, @Param("query")PagesQuery query);
}
