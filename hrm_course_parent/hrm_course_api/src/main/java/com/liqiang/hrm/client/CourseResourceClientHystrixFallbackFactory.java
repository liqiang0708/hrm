package com.liqiang.hrm.client;

import com.liqiang.hrm.domain.CourseResource;
import com.liqiang.hrm.query.CourseResourceQuery;
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
public class CourseResourceClientHystrixFallbackFactory implements FallbackFactory<CourseResourceClient> {

    @Override
    public CourseResourceClient create(Throwable throwable) {
        return new CourseResourceClient() {
            @Override
            public AjaxResult save(CourseResource courseResource) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public CourseResource get(Long id) {
                return null;
            }

            @Override
            public List<CourseResource> list() {
                return null;
            }

            @Override
            public PageList<CourseResource> json(CourseResourceQuery query) {
                return null;
            }
        };
    }
}
