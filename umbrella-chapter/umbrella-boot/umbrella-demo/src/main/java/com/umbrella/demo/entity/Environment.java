package com.umbrella.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("demo_environment")
public class Environment {
    @Field(value = "_id" , targetType = FieldType.OBJECT_ID)
    private Long id;
    @Field(value = "temperature",targetType = FieldType.DECIMAL128)
    private BigDecimal temperature;
    @Field(value = "humidity",targetType = FieldType.DECIMAL128)
    private BigDecimal humidity;
    @Field(value = "illumination",targetType = FieldType.DECIMAL128)
    private BigDecimal illumination;
    @Field(value = "windPower",targetType = FieldType.DECIMAL128)
    private BigDecimal windPower;
    @Field(value = "createAt",targetType = FieldType.DATE_TIME)
    private Date creatAt;

}
