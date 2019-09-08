package com.liqiang.hrm.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.liqiang.hrm.domain.Course;
import com.liqiang.hrm.query.CourseQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 * @author liqiang
 * @since 2019-09-04
 */
public interface CourseMapper extends BaseMapper<Course> {

    List<Course> loadListPage(Page<Course> page, @Param("query") CourseQuery query);
    //批量修改状态 上线
    void batchOnline(List<Long> longs);
    //批量修改状态 下线
    void batchOffline(List<Long> longs);

    //void inSert(Course course);
}
