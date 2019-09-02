package com.liqiang.hrm.service.impl;

import com.liqiang.hrm.domain.Tenant;
import com.liqiang.hrm.mapper.TenantMapper;
import com.liqiang.hrm.service.ITenantService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liqiang
 * @since 2019-09-02
 */
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant> implements ITenantService {

}
