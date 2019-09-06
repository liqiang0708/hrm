package com.liqiang.hrm.service.impl;

import com.liqiang.hrm.doc.EsCourse;
import com.liqiang.hrm.query.EsCourseQuery;
import com.liqiang.hrm.repository.CourseRepository;
import com.liqiang.hrm.service.IEsCourseService;
import com.liqiang.hrm.util.PageList;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liqiang
 * @since 2019-09-05
 */
@Service
public class EsCourseServiceImpl implements IEsCourseService {
    @Autowired
    private CourseRepository repository;

    @Override
    public void updateById(EsCourse esCourse) {
        repository.save(esCourse);
    }

    @Override
    public void insert(EsCourse esCourse) {
        repository.save(esCourse);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public EsCourse selectById(Long id) {
        return repository.findById(id).get();//findById(id)只能得到option  需要.get()
    }

    @Override
    public List<EsCourse> selectList(Object o) {
        //Page page = (Page) repository.findAll();//findAll()得到Iterable  这里需要List
        //return page.getContent();
        List<EsCourse> list = new ArrayList<>();
        for (EsCourse esCourse:repository.findAll()) {
            list.add(esCourse);
        }
        return list;

    }

    @Override
    public PageList<EsCourse> selectListPage(EsCourseQuery query) {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        BoolQueryBuilder bool = QueryBuilders.boolQuery();
        //模糊查询 @TODO
        bool.must(QueryBuilders.matchQuery("intro", "zhang"));
        //精确过滤 @TODO
        List<QueryBuilder> filters = bool.filter();
        filters.add(QueryBuilders.rangeQuery("age").gte(0).lte(200));

        builder.withQuery(bool); //query bool must(filter)
        //排序 @TODO
        builder.withSort(SortBuilders.fieldSort("age").order(SortOrder.ASC));

        //分页 第一页从0开始
        builder.withPageable(PageRequest.of(query.getPage()-1, query.getRows()));

        //构造查询条件
        NativeSearchQuery esQuery = builder.build();
        //查询
        Page<EsCourse> page = repository.search(esQuery);
        return new PageList<>(page.getTotalElements(),page.getContent());
    }

    @Override
    public void batchSave(List<EsCourse> esCourseList) {
        repository.saveAll(esCourseList);
    }

    @Override
    public void batchDel(List<EsCourse> esCourseList) {
        repository.deleteAll(esCourseList);
    }
}
