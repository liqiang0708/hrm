package com.liqiang.hrm;

import com.baomidou.mybatisplus.plugins.Page;
import com.liqiang.hrm.domain.Employee;
import com.liqiang.hrm.domain.Systemdictionaryitem;
import com.liqiang.hrm.service.IEmployeeService;
import com.liqiang.hrm.service.ISystemdictionaryService;
import com.liqiang.hrm.service.ISystemdictionaryitemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = System_9001_Application.class)
public class SystemTest {
    @Autowired
    private ISystemdictionaryService systemdictionaryService;
    @Autowired
    private ISystemdictionaryitemService systemdictionaryitemService;
    @Autowired
    private IEmployeeService employeeService;
    @Test
    public void test() throws Exception{
        Page<Systemdictionaryitem> selectPage = systemdictionaryitemService.selectPage(new Page<>());
        List<Systemdictionaryitem> list = selectPage.getRecords();
        list.forEach(p-> System.out.println(p));
        System.out.println(selectPage.getTotal());
    }

    @Test
    public void testItem() throws Exception{
        System.out.println(systemdictionaryService.selectById(6));
    }

    @Test
    public void testEmp() throws Exception{
        List<Employee> list = employeeService.selectList(null);
        list.forEach(employee -> System.out.println(employee));
    }
}
