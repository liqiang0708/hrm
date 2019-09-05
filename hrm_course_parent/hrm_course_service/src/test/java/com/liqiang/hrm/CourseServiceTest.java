package com.liqiang.hrm;

import com.liqiang.hrm.domain.Course;
import com.liqiang.hrm.query.CourseQuery;
import com.liqiang.hrm.service.ICourseService;
import com.liqiang.hrm.util.PageList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Course_9002_Application.class)
public class CourseServiceTest {

    @Autowired
    private ICourseService courseService;
    @Test
    public void selectListPage() {
        PageList<Course> pageList = courseService.selectListPage(new CourseQuery());
        System.out.println(pageList.getTotal());
        System.out.println(pageList.getRows().size());
        for (Course course : pageList.getRows()) {
            System.out.println(course);
            System.out.println(course.getCourseType());
            System.out.println("=========================");
        }
    }
}