package com.liqiang.hrm.client;

import com.liqiang.hrm.doc.EsCourse;
import com.liqiang.hrm.query.EsCourseQuery;
import com.liqiang.hrm.util.AjaxResult;
import com.liqiang.hrm.util.PageList;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liqiang
 * @date 2019-09-05
 */
@Component
public class EsCourseClientHystrixFallbackFactory implements FallbackFactory<EsCourseClient> {

    @Override
    public EsCourseClient create(Throwable throwable) {
        return new EsCourseClient() {
            @Override
            public AjaxResult save(EsCourse esCourse) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public EsCourse get(Long id) {
                return null;
            }

            @Override
            public List<EsCourse> list() {
                return null;
            }

            @Override
            public PageList<EsCourse> json(EsCourseQuery query) {
                return null;
            }

            @Override
            public void batchSave(List<EsCourse> esCourseList) {
            }

            @Override
            public void batchDel(List<EsCourse> esCourseList) {
            }
        };
    }
}
