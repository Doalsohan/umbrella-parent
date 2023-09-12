package com.umbrella.demo.mapper;

import com.umbrella.demo.entity.TestStock;
import com.umbrella.demo.entity.example.TestStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TestStockMapper {
    /**
     * @mbg.generated
     */
    long countByExample(TestStockExample example);

    /**
     * @mbg.generated
     */
    int deleteByExample(TestStockExample example);

    /**
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * @mbg.generated
     */
    int insert(TestStock record);

    /**
     * @mbg.generated
     */
    int insertSelective(@Param("record") TestStock record, @Param("selective") TestStock.Column ... selective);

    /**
     * @mbg.generated
     */
    TestStock selectOneByExample(TestStockExample example);

    /**
     * @mbg.generated
     */
    TestStock selectOneByExampleSelective(@Param("example") TestStockExample example, @Param("selective") TestStock.Column ... selective);

    /**
     * @mbg.generated
     */
    List<TestStock> selectByExampleSelective(@Param("example") TestStockExample example, @Param("selective") TestStock.Column ... selective);

    /**
     * @mbg.generated
     */
    List<TestStock> selectByExample(TestStockExample example);

    /**
     * @mbg.generated
     */
    TestStock selectByPrimaryKeySelective(@Param("id") Long id, @Param("selective") TestStock.Column ... selective);

    /**
     * @mbg.generated
     */
    TestStock selectByPrimaryKey(Long id);

    /**
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TestStock record, @Param("example") TestStockExample example, @Param("selective") TestStock.Column ... selective);

    /**
     * @mbg.generated
     */
    int updateByExample(@Param("record") TestStock record, @Param("example") TestStockExample example);

    /**
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(@Param("record") TestStock record, @Param("selective") TestStock.Column ... selective);

    /**
     * @mbg.generated
     */
    int updateByPrimaryKey(TestStock record);

    /**
     * @mbg.generated
     */
    int batchInsert(@Param("list") List<TestStock> list);

    /**
     * @mbg.generated
     */
    int batchInsertSelective(@Param("list") List<TestStock> list, @Param("selective") TestStock.Column ... selective);

    /**
     * @mbg.generated
     */
    int upsert(TestStock record);

    /**
     * @mbg.generated
     */
    int upsertSelective(@Param("record") TestStock record, @Param("selective") TestStock.Column ... selective);

    /**
     * @mbg.generated
     */
    int batchUpsert(@Param("list") List<TestStock> list);

    /**
     * @mbg.generated
     */
    int batchUpsertSelective(@Param("list") List<TestStock> list, @Param("selective") TestStock.Column ... selective);
}