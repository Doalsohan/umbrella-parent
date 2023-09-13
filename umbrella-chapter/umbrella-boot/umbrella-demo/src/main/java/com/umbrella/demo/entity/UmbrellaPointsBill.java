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
@Document("umbrella_points_bill")
public class UmbrellaPointsBill {
    @Field(value = "_id" , targetType = FieldType.OBJECT_ID)
    private Long id;
    @Field(value = "userId",targetType = FieldType.INT64)
    private Long userId;
    @Field(value = "operateType",targetType = FieldType.INT32)
    private Integer operateType;
    @Field(value = "bizType",targetType = FieldType.INT32)
    private Integer bizType;
    @Field(value = "points",targetType = FieldType.DECIMAL128)
    private BigDecimal points;
    @Field(value = "bizId",targetType = FieldType.INT64)
    private Long bizId;
    @Field(value = "createAt",targetType = FieldType.DATE_TIME)
    private Date creatAt;

}
