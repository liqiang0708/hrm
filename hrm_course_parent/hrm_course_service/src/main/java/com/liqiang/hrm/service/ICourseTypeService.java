package com.liqiang.hrm.service;

import com.baomidou.mybatisplus.service.IService;
import com.liqiang.hrm.domain.CourseType;
import com.liqiang.hrm.query.CourseTypeQuery;
import com.liqiang.hrm.util.PageList;

/**
 * <p>
 * 课程目录 服务类
 * </p>
 *
 * @author liqiang
 * @since 2019-09-01
 */
public interface ICourseTypeService extends IService<CourseType> {
    /**
     * 高级查询+分页+关联查询
     * @param query
     * @return
     */
    PageList<CourseType> selectListPage(CourseTypeQuery query);
}
