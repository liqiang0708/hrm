package com.liqiang.hrm.service;

import com.baomidou.mybatisplus.service.IService;
import com.liqiang.hrm.domain.Course;
import com.liqiang.hrm.query.CourseQuery;
import com.liqiang.hrm.util.PageList;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 * @author liqiang
 * @since 2019-09-04
 */
public interface ICourseService extends IService<Course> {
    /**
     * 分页+高级查询+关联查询
     * @param query
     * @return 分页对象
     */
    PageList<Course> selectListPage(CourseQuery query);
    /**
     * 课程上线
     * @param ids 批量上线的课程的id 集合
     */
    void onLine(Long[] ids);
    /**
     * 课程下线
     * @param ids 批量下线的课程的id 集合
     */
    void offLine(Long[] ids);

    List<Course> getBatchIds(Long[] ids);
}
