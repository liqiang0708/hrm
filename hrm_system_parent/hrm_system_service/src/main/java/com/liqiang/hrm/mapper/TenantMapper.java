package com.liqiang.hrm.mapper;

import com.liqiang.hrm.domain.Tenant;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liqiang
 * @since 2019-09-02
 */
public interface TenantMapper extends BaseMapper<Tenant> {
    /**
     * 保存机构所关联的套餐的 中间表信息
     * @param mealsMap
     */
    void saveTenantMeals(List<Map<String,Long>> mealsMap);

    void removeTenantMeal(Serializable id);
}
