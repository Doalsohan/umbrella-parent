package com.umbrella.base.mapper;

import com.umbrella.base.entity.UmbrellaUser;
import com.umbrella.base.entity.example.UmbrellaUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UmbrellaUserMapper {
    /**
     * @mbg.generated
     */
    long countByExample(UmbrellaUserExample example);

    /**
     * @mbg.generated
     */
    int deleteByExample(UmbrellaUserExample example);

    /**
     * @mbg.generated
     */
    int insert(UmbrellaUser record);

    /**
     * @mbg.generated
     */
    int insertSelective(@Param("record") UmbrellaUser record, @Param("selective") UmbrellaUser.Column ... selective);

    /**
     * @mbg.generated
     */
    UmbrellaUser selectOneByExample(UmbrellaUserExample example);

    /**
     * @mbg.generated
     */
    UmbrellaUser selectOneByExampleSelective(@Param("example") UmbrellaUserExample example, @Param("selective") UmbrellaUser.Column ... selective);

    /**
     * @mbg.generated
     */
    List<UmbrellaUser> selectByExampleSelective(@Param("example") UmbrellaUserExample example, @Param("selective") UmbrellaUser.Column ... selective);

    /**
     * @mbg.generated
     */
    List<UmbrellaUser> selectByExample(UmbrellaUserExample example);

    /**
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") UmbrellaUser record, @Param("example") UmbrellaUserExample example, @Param("selective") UmbrellaUser.Column ... selective);

    /**
     * @mbg.generated
     */
    int updateByExample(@Param("record") UmbrellaUser record, @Param("example") UmbrellaUserExample example);

    /**
     * @mbg.generated
     */
    int batchInsert(@Param("list") List<UmbrellaUser> list);

    /**
     * @mbg.generated
     */
    int batchInsertSelective(@Param("list") List<UmbrellaUser> list, @Param("selective") UmbrellaUser.Column ... selective);

    /**
     * @mbg.generated
     */
    int upsert(UmbrellaUser record);

    /**
     * @mbg.generated
     */
    int upsertSelective(@Param("record") UmbrellaUser record, @Param("selective") UmbrellaUser.Column ... selective);

    /**
     * @mbg.generated
     */
    int batchUpsert(@Param("list") List<UmbrellaUser> list);

    /**
     * @mbg.generated
     */
    int batchUpsertSelective(@Param("list") List<UmbrellaUser> list, @Param("selective") UmbrellaUser.Column ... selective);

    /**
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") UmbrellaUserExample example);
}