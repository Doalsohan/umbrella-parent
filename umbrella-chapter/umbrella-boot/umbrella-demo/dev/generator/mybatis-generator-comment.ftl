<?xml version="1.0" encoding="UTF-8"?>
<template>
    <!-- #############################################################################################################
    /**
     * Adds a comment for a model class.  The Java code merger should
     * be notified not to delete the entire class in case any manual
     * changes have been made.  So this method will always use the
     * "do not delete" annotation.
     *
     * Because of difficulties with the Java file merger, the default implementation
     * of this method should NOT add comments.  Comments should only be added if
     * specifically requested by the user (for example, by enabling table remark comments).
     *
     * @param topLevelClass
     *            the top level class
     * @param introspectedTable
     *            the introspected table
     */
    -->
    <comment ID="addModelClassComment"><![CDATA[
/**
 * <p>表名：<b>${introspectedTable.fullyQualifiedTable}</b></p>
<#if introspectedTable.remarks?? && introspectedTable.remarks != ''>
 * <p>注释：</p>
<#list introspectedTable.remarks?split("\n") as remark>
 * <p>&nbsp;&nbsp;${remark}</p>
</#list>
</#if>
 * <p></p>
 * <p>此类由 MyBatis Generator 生成</p>
 * ${mgb} do_not_delete_during_merge
 */
    ]]></comment>

    <!-- #############################################################################################################
    /**
     * This method should add a Javadoc comment to the specified field. The field is related to the specified table and
     * is used to hold the value of the specified column.
     * <p>
     *
     * <b>Important:</b> This method should add a the nonstandard JavaDoc tag "@mbg.generated" to the comment. Without
     * this tag, the Eclipse based Java merge feature will fail.
     *
     * @param field
     *            the field
     * @param introspectedTable
     *            the introspected table
     * @param introspectedColumn
     *            the introspected column
     */
    -->
    <comment ID="addFieldComment"><![CDATA[
/**
<#if introspectedColumn??>
    <#if introspectedColumn.remarks?? && introspectedColumn.remarks != ''>
        <#list introspectedColumn.remarks?split("\n") as remark>
 * ${remark}
        </#list>
    </#if>
 * ${introspectedColumn.actualColumnName}
 *
</#if>
 * ${mgb}
 */
    ]]></comment>


    <!-- #############################################################################################################
    /**
     * Adds the general method comment.
     *
     * @param method
     *            the method
     * @param introspectedTable
     *            the introspected table
     */
    -->
    <comment ID="addGeneralMethodComment"><![CDATA[
/**
 * ${mgb}
 */
    ]]></comment>


    <!-- #############################################################################################################
    /**
     * This method should add a suitable comment as a child element of the specified xmlElement to warn users that the
     * element was generated and is subject to regeneration.
     *
     * @param xmlElement
     *            the xml element
     */
    -->
    <comment ID="addComment"><![CDATA[
<!--
  WARNING - ${mgb}
  此元素由 MyBatis Generator 自动生成，请勿修改。
-->
    ]]></comment>

 <!-- #############################################################################################################
    /**
     * Adds the inner class comment.
     *
     * @param innerClass
     *            the inner class
     * @param introspectedTable
     *            the introspected table
     * @param markAsDoNotDelete
     *            the mark as do not delete
     */
    -->
    <comment ID="addClassComment"><![CDATA[
/**
 * <p>此类对应表 ${introspectedTable.fullyQualifiedTable}</p>
 *
 * <p>此类由 MyBatis Generator 生成</p>
 * ${mgb}<#if markAsDoNotDelete?? && markAsDoNotDelete> do_not_delete_during_merge</#if>
 */
    ]]></comment>

    <!-- #############################################################################################################
    /**
     * Adds the interface comment.
     *
     * @param innerInterface
     *            the inner interface
     * @param introspectedTable
     *            the introspected table
     */
    -->
    <comment ID="addInterfaceComment"><![CDATA[
/**
 * <p>此接口对应表 ${introspectedTable.fullyQualifiedTable}</p>
 *
 * <p>此接口由 MyBatis Generator 生成</p>
 * ${mgb}
 */
    ]]></comment>

    <!-- #############################################################################################################
    /**
     * Adds the enum comment.
     *
     * @param innerEnum
     *            the inner enum
     * @param introspectedTable
     *            the introspected table
     */
    -->
    <comment ID="addEnumComment"><![CDATA[
/**
 * <p>此枚举对应表 ${introspectedTable.fullyQualifiedTable}</p>
 * 
 * <p>此枚举由 MyBatis Generator 生成</p>
 * ${mgb}
 */
    ]]></comment>

    <!-- #############################################################################################################
    /**
     * This method is called to add a file level comment to a generated java file. This method could be used to add a
     * general file comment (such as a copyright notice). However, note that the Java file merge function in Eclipse
     * does not deal with this comment. If you run the generator repeatedly, you will only retain the comment from the
     * initial run.
     * <p>
     *
     * The default implementation does nothing.
     *
     * @param compilationUnit
     *            the compilation unit
     */
    -->
    <comment ID="addJavaFileComment"></comment>



    <!-- #############################################################################################################
    /**
     * This method is called to add a comment as the first child of the root element. This method could be used to add a
     * general file comment (such as a copyright notice). However, note that the XML file merge function does not deal
     * with this comment. If you run the generator repeatedly, you will only retain the comment from the initial run.
     * <p>
     *
     * The default implementation does nothing.
     *
     * @param rootElement
     *            the root element
     */
    -->
    <comment ID="addRootComment"></comment>
   



    <!-- #############################################################################################################
    /**
     * Adds the getter comment.
     *
     * @param method
     *            the method
     * @param introspectedTable
     *            the introspected table
     * @param introspectedColumn
     *            the introspected column
     */
    -->
    <comment ID="addGetterComment"><![CDATA[
<#if introspectedColumn??>
/**
 * This method was generated by MyBatis Generator.
 * This method returns the value of the database column ${introspectedTable.fullyQualifiedTable}.${introspectedColumn.actualColumnName}
 *
 * @return the value of ${introspectedTable.fullyQualifiedTable}.${introspectedColumn.actualColumnName}
 *
 * ${mgb}
 * @project https://github.com/itfsw/mybatis-generator-plugin
 */
<#else>
/**
 * This method was generated by MyBatis Generator.
 * This method returns the value of the field ${method.name?replace("get","")?replace("is", "")?uncap_first}
 *
 * @return the value of field ${method.name?replace("get","")?replace("is", "")?uncap_first}
 *
 * ${mgb}
 * @project https://github.com/itfsw/mybatis-generator-plugin
 */
</#if>
        ]]></comment>

    <!-- #############################################################################################################
    /**
     * Adds the setter comment.
     *
     * @param method
     *            the method
     * @param introspectedTable
     *            the introspected table
     * @param introspectedColumn
     *            the introspected column
     */
    -->
    <comment ID="addSetterComment"><![CDATA[
<#if introspectedColumn??>
/**
 * This method was generated by MyBatis Generator.
 * This method sets the value of the database column ${introspectedTable.fullyQualifiedTable}.${introspectedColumn.actualColumnName}
 *
 * @param ${method.parameters[0].name} the value for ${introspectedTable.fullyQualifiedTable}.${introspectedColumn.actualColumnName}
 *
 * ${mgb}
 * @project https://github.com/itfsw/mybatis-generator-plugin
 */
<#else>
/**
 * This method was generated by MyBatis Generator.
 * This method sets the value of the field ${method.name?replace("set","")?uncap_first}
 *
 * @param ${method.parameters[0].name} the value for field ${method.name?replace("set","")?uncap_first}
 *
 * ${mgb}
 * @project https://github.com/itfsw/mybatis-generator-plugin
 */
</#if>
        ]]></comment>


</template>