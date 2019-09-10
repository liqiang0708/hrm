package com.liqiang.hrm;

import com.liqiang.hrm.domain.Pages;
import com.liqiang.hrm.query.PagesQuery;
import com.liqiang.hrm.service.IPagesService;
import com.liqiang.hrm.util.PageList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Pages_9006_Application.class)
public class PagesTest {
    @Autowired
    private IPagesService pagesService;

    @Test
    public void testTotal() throws Exception{
        PageList<Pages> pageList = pagesService.selectListPage(new PagesQuery());
        pageList.getRows().forEach(pages -> System.out.println(pages));
        /*for (Pages pages : pageList.getRows()) {
            System.out.println(pages.getSite());
        }*/
    }
}
