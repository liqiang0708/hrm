package com.liqiang.hrm.service;

import com.baomidou.mybatisplus.service.IService;
import com.liqiang.hrm.domain.Course;
import com.liqiang.hrm.query.CourseQuery;
import com.liqiang.hrm.util.PageList;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liqiang
 * @since 2019-09-04
 */
public interface ICourseService extends IService<Course> {
    /**
     * 分页+高级查询+关联查询
     * @param query
     * @return
     */
    PageList<Course> selectListPage(CourseQuery query);
}
