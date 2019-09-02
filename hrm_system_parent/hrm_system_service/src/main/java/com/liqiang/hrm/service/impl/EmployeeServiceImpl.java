package com.liqiang.hrm.service.impl;

import com.liqiang.hrm.domain.Employee;
import com.liqiang.hrm.mapper.EmployeeMapper;
import com.liqiang.hrm.service.IEmployeeService;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
