package com.liqiang.hrm;

import com.liqiang.hrm.service.ICourseTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Course_9002_Application.class)
public class CourseTest {
    @Autowired
    private ICourseTypeService courseTypeService;

    @Test
    public void testC() throws Exception{
        courseTypeService.selectList(null).forEach(courseType -> System.out.println(courseType));
    }
}
