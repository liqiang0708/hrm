package com.liqiang.hrm.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.liqiang.hrm.domain.CourseType;
import com.liqiang.hrm.query.CourseTypeQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 课程目录 Mapper 接口
 * </p>
 *
 * @author liqiang
 * @since 2019-09-01
 */
public interface CourseTypeMapper extends BaseMapper<CourseType> {
    /**
     * @param page  必须作为第一个参数
     * @param query
     * @return
     */
    List<CourseType> loadListPage(Pagination page, @Param("query") CourseTypeQuery query);
}
