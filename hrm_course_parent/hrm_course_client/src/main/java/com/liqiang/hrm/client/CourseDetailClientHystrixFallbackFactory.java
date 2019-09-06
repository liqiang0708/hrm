package com.liqiang.hrm.client;

import com.liqiang.hrm.domain.CourseDetail;
import com.liqiang.hrm.query.CourseDetailQuery;
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
public class CourseDetailClientHystrixFallbackFactory implements FallbackFactory<CourseDetailClient> {

    @Override
    public CourseDetailClient create(Throwable throwable) {
        return new CourseDetailClient() {
            @Override
            public AjaxResult save(CourseDetail courseDetail) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public CourseDetail get(Long id) {
                return null;
            }

            @Override
            public List<CourseDetail> list() {
                return null;
            }

            @Override
            public PageList<CourseDetail> json(CourseDetailQuery query) {
                return null;
            }
        };
    }
}
