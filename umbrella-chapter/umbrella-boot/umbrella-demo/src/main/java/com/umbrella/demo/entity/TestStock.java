package com.umbrella.demo.entity;

import java.util.ArrayList;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>表名：<b>test_stock</b></p>
 * <p></p>
 * <p>此类由 MyBatis Generator 生成</p>
 * @mbg.generated do_not_delete_during_merge
 */
@NoArgsConstructor
@Accessors(chain = true)
@Data
@AllArgsConstructor
@Builder
public class TestStock {
    /**
     * 主键
     * ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 库存
     * stock
     *
     * @mbg.generated
     */
    private Integer stock;

    /**
     * 商品名称
     * goods_name
     *
     * @mbg.generated
     */
    private String goodsName;

    /**
     * 商品编码
     * goods_num
     *
     * @mbg.generated
     */
    private String goodsNum;

    /**
     * 供应商ID
     * supplier_id
     *
     * @mbg.generated
     */
    private Integer supplierId;

    /**
     * <p>此枚举对应表 test_stock</p>
     * 
     * <p>此枚举由 MyBatis Generator 生成</p>
     * @mbg.generated
     */
    public enum Column {
        id("ID", "id", "BIGINT", false),
        stock("stock", "stock", "INTEGER", false),
        goodsName("goods_name", "goodsName", "VARCHAR", false),
        goodsNum("goods_num", "goodsNum", "VARCHAR", false),
        supplierId("supplier_id", "supplierId", "INTEGER", false);

        /**
         * @mbg.generated
         */
        private static final String BEGINNING_DELIMITER = "\"";

        /**
         * @mbg.generated
         */
        private static final String ENDING_DELIMITER = "\"";

        /**
         * @mbg.generated
         */
        private final String column;

        /**
         * @mbg.generated
         */
        private final boolean isColumnNameDelimited;

        /**
         * @mbg.generated
         */
        private final String javaProperty;

        /**
         * @mbg.generated
         */
        private final String jdbcType;

        /**
         * @mbg.generated
         */
        public String value() {
            return this.column;
        }

        /**
         * @mbg.generated
         */
        public String getValue() {
            return this.column;
        }

        /**
         * @mbg.generated
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * @mbg.generated
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * @mbg.generated
         */
        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        /**
         * @mbg.generated
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * @mbg.generated
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * @mbg.generated
         */
        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        /**
         * @mbg.generated
         */
        public static Column[] all() {
            return Column.values();
        }

        /**
         * @mbg.generated
         */
        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }

        /**
         * @mbg.generated
         */
        public String getAliasedEscapedColumnName() {
            return this.getEscapedColumnName();
        }
    }
}