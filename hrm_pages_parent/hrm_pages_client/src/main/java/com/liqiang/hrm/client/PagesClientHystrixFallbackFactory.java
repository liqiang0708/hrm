package com.liqiang.hrm.client;

import com.liqiang.hrm.domain.Pages;
import com.liqiang.hrm.query.PagesQuery;
import com.liqiang.hrm.util.AjaxResult;
import com.liqiang.hrm.util.PageList;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liqiang
 * @date 2019-09-08
 */
@Component
public class PagesClientHystrixFallbackFactory implements FallbackFactory<PagesClient> {

    @Override
    public PagesClient create(Throwable throwable) {
        return new PagesClient() {
            @Override
            public AjaxResult save(Pages pages) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public Pages get(Long id) {
                return null;
            }

            @Override
            public List<Pages> list() {
                return null;
            }

            @Override
            public PageList<Pages> json(PagesQuery query) {
                return null;
            }
        };
    }
}
