package com.umbrella.base.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>表名：<b>umbrella_user</b></p>
 * <p></p>
 * <p>此类由 MyBatis Generator 生成</p>
 * @mbg.generated do_not_delete_during_merge
 */
@NoArgsConstructor
@Accessors(chain = true)
@Data
@AllArgsConstructor
@Builder
public class UmbrellaUser {
    /**
     * @mbg.generated
     */
    public static final Boolean IS_DELETED = Del.IS_DELETED.value();

    /**
     * @mbg.generated
     */
    public static final Boolean NOT_DELETED = Del.NOT_DELETED.value();

    /**
     * 主键
     * id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 姓名
     * name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *  昵称
     * nick_name
     *
     * @mbg.generated
     */
    private String nickName;

    /**
     * 手机号码
     * phone
     *
     * @mbg.generated
     */
    private String phone;

    /**
     * 头像
     * avtor
     *
     * @mbg.generated
     */
    private String avtor;

    /**
     * 邮箱
     * email
     *
     * @mbg.generated
     */
    private String email;

    /**
     * create_at
     *
     * @mbg.generated
     */
    private Date createAt;

    /**
     * update_at
     *
     * @mbg.generated
     */
    private Date updateAt;

    /**
     * delete_at
     *
     * @mbg.generated
     */
    private Date deleteAt;

    /**
     * del
     *
     * @mbg.generated
     */
    private Boolean del;

    /**
     * @mbg.generated
     */
    public void andLogicalDeleted(boolean deleted) {
        setDel(deleted ? Del.IS_DELETED.value() : Del.NOT_DELETED.value());
    }

    /**
     * <p>此枚举对应表 umbrella_user</p>
     * 
     * <p>此枚举由 MyBatis Generator 生成</p>
     * @mbg.generated
     */
    public enum Del {
        NOT_DELETED(new Boolean("0"), "未删除"),
        IS_DELETED(new Boolean("1"), "已删除");

        /**
         * @mbg.generated
         */
        private final Boolean value;

        /**
         * @mbg.generated
         */
        private final String name;

        /**
         * @mbg.generated
         */
        Del(Boolean value, String name) {
            this.value = value;
            this.name = name;
        }

        /**
         * @mbg.generated
         */
        public Boolean getValue() {
            return this.value;
        }

        /**
         * @mbg.generated
         */
        public Boolean value() {
            return this.value;
        }

        /**
         * @mbg.generated
         */
        public String getName() {
            return this.name;
        }

        /**
         * @mbg.generated
         */
        public static Del parseValue(Boolean value) {
            if (value != null) {
                for (Del item : values()) {
                    if (item.value.equals(value)) {
                        return item;
                    }
                }
            }
            return null;
        }

        /**
         * @mbg.generated
         */
        public static Del parseName(String name) {
            if (name != null) {
                for (Del item : values()) {
                    if (item.name.equals(name)) {
                        return item;
                    }
                }
            }
            return null;
        }
    }

    /**
     * <p>此枚举对应表 umbrella_user</p>
     * 
     * <p>此枚举由 MyBatis Generator 生成</p>
     * @mbg.generated
     */
    public enum Column {
        id("id", "id", "BIGINT", false),
        name("name", "name", "VARCHAR", false),
        nickName("nick_name", "nickName", "VARCHAR", false),
        phone("phone", "phone", "VARCHAR", false),
        avtor("avtor", "avtor", "VARCHAR", false),
        email("email", "email", "VARCHAR", false),
        createAt("create_at", "createAt", "TIMESTAMP", false),
        updateAt("update_at", "updateAt", "TIMESTAMP", false),
        deleteAt("delete_at", "deleteAt", "TIMESTAMP", false),
        del("del", "del", "BIT", false);

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