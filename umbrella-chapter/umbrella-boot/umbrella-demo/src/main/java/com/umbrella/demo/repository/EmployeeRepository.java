package com.umbrella.demo.repository;

import com.umbrella.demo.entity.EmployeeBean;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmployeeRepository extends ElasticsearchRepository<EmployeeBean,Long> {
}
