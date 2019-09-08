package com.liqiang.hrm.client;

import com.liqiang.hrm.domain.PagesConfig;
import com.liqiang.hrm.query.PagesConfigQuery;
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
public class PagesConfigClientHystrixFallbackFactory implements FallbackFactory<PagesConfigClient> {

    @Override
    public PagesConfigClient create(Throwable throwable) {
        return new PagesConfigClient() {
            @Override
            public AjaxResult save(PagesConfig pagesConfig) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public PagesConfig get(Long id) {
                return null;
            }

            @Override
            public List<PagesConfig> list() {
                return null;
            }

            @Override
            public PageList<PagesConfig> json(PagesConfigQuery query) {
                return null;
            }
        };
    }
}
