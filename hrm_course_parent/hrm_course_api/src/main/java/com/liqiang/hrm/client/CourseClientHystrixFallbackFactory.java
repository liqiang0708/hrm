package com.liqiang.hrm.client;

import com.liqiang.hrm.domain.Course;
import com.liqiang.hrm.query.CourseQuery;
import com.liqiang.hrm.util.AjaxResult;
import com.liqiang.hrm.util.PageList;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liqiang
 * @date 2019-09-04
 */
@Component
public class CourseClientHystrixFallbackFactory implements FallbackFactory<CourseClient> {

    @Override
    public CourseClient create(Throwable throwable) {
        return new CourseClient() {
            @Override
            public AjaxResult save(Course course) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public Course get(Long id) {
                return null;
            }

            @Override
            public List<Course> list() {
                return null;
            }

            @Override
            public PageList<Course> json(CourseQuery query) {
                return null;
            }
        };
    }
}
