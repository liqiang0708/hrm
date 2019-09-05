package com.liqiang.hrm.repository;

import com.liqiang.hrm.doc.EsCourse;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CourseRepository extends ElasticsearchRepository<EsCourse,Long> {
}
