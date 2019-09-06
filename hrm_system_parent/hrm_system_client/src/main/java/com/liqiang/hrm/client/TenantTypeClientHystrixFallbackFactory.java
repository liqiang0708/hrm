package com.liqiang.hrm.client;

import com.liqiang.hrm.domain.TenantType;
import com.liqiang.hrm.query.TenantTypeQuery;
import com.liqiang.hrm.util.AjaxResult;
import com.liqiang.hrm.util.PageList;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liqiang
 * @date 2019-09-02
 */
@Component
public class TenantTypeClientHystrixFallbackFactory implements FallbackFactory<TenantTypeClient> {

    @Override
    public TenantTypeClient create(Throwable throwable) {
        return new TenantTypeClient() {
            @Override
            public AjaxResult save(TenantType tenantType) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public TenantType get(Long id) {
                return null;
            }

            @Override
            public List<TenantType> list() {
                return null;
            }

            @Override
            public PageList<TenantType> json(TenantTypeQuery query) {
                return null;
            }
        };
    }
}
