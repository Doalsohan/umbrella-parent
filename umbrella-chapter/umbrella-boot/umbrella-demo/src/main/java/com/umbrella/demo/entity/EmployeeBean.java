package com.umbrella.demo.entity;


import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "employee_index",createIndex = true)
public class EmployeeBean {

    @Id
    private Long id;

    /**
     * 员工编码
     */
    @Field(type = FieldType.Keyword)
    private String studentCode;

    /**
     * 员工姓名
     */
    @Field(type = FieldType.Keyword)
    private String name;

    /**
     * 员工简历
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String desc;

    /**
     * 员工住址
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String address;

    /**
     * 手机号码
     */
    @Field(type = FieldType.Keyword)
    private String mobile;
}
