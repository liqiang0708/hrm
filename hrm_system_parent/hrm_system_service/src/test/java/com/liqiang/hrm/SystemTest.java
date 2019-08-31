package com.liqiang.hrm;

import com.baomidou.mybatisplus.plugins.Page;
import com.liqiang.hrm.domain.Employee;
import com.liqiang.hrm.domain.Systemdictionary;
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
        Page<Systemdictionary> page = new Page<>();
        List<Systemdictionary> list = systemdictionaryService.selectPage(page).getRecords();
        list.forEach(p-> System.out.println(p));
    }

    @Test
    public void testItem() throws Exception{
        System.out.println(systemdictionaryitemService.selectById(9));
    }

    @Test
    public void testEmp() throws Exception{
        List<Employee> list = employeeService.selectList(null);
        list.forEach(employee -> System.out.println(employee));
    }
}
