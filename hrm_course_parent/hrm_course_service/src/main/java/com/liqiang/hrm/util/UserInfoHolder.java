package com.liqiang.hrm.util;


import com.liqiang.hrm.domain.Employee;
import com.liqiang.hrm.domain.Tenant;

public class UserInfoHolder {
    public static Tenant getTenant(){
        Tenant currentLoginUserTenant = new Tenant();
        currentLoginUserTenant.setId(26L);
        currentLoginUserTenant.setCompanyName("源码时代");
        return currentLoginUserTenant;
    }
    public static Employee getLoginUser(){
        Employee employee = new Employee();
        employee.setId(42L);
        employee.setUsername("模拟管理员");
        return employee;
    }
}
