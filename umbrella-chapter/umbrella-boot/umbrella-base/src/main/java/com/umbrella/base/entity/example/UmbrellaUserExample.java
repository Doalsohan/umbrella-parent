package com.umbrella.base.entity.example;

import com.umbrella.base.entity.UmbrellaUser;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UmbrellaUserExample {
    /**
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * @mbg.generated
     */
    protected Integer offset;

    /**
     * @mbg.generated
     */
    protected Integer rows;

    /**
     * @mbg.generated
     */
    public UmbrellaUserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * @mbg.generated
     */
    public UmbrellaUserExample orderBy(String orderByClause) {
        this.setOrderByClause(orderByClause);
        return this;
    }

    /**
     * @mbg.generated
     */
    public UmbrellaUserExample orderBy(String ... orderByClauses) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < orderByClauses.length; i++) {
            sb.append(orderByClauses[i]);
            if (i < orderByClauses.length - 1) {
                sb.append(" , ");
            }
        }
        this.setOrderByClause(sb.toString());
        return this;
    }

    /**
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria(this);
        return criteria;
    }

    /**
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
        rows = null;
        offset = null;
    }

    /**
     * @mbg.generated
     */
    public static Criteria newAndCreateCriteria() {
        UmbrellaUserExample example = new UmbrellaUserExample();
        return example.createCriteria();
    }

    /**
     * @mbg.generated
     */
    public UmbrellaUserExample when(boolean condition, IExampleWhen then) {
        if (condition) {
            then.example(this);
        }
        return this;
    }

    /**
     * @mbg.generated
     */
    public UmbrellaUserExample when(boolean condition, IExampleWhen then, IExampleWhen otherwise) {
        if (condition) {
            then.example(this);
        } else {
            otherwise.example(this);
        }
        return this;
    }

    /**
     * @mbg.generated
     */
    public UmbrellaUserExample distinct(boolean distinct) {
        this.setDistinct(distinct);
        return this;
    }

    /**
     * @mbg.generated
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * @mbg.generated
     */
    public Integer getOffset() {
        return this.offset;
    }

    /**
     * @mbg.generated
     */
    public void setRows(Integer rows) {
        this.rows = rows;
    }

    /**
     * @mbg.generated
     */
    public Integer getRows() {
        return this.rows;
    }

    /**
     * @mbg.generated
     */
    public UmbrellaUserExample limit(Integer rows) {
        this.rows = rows;
        return this;
    }

    /**
     * @mbg.generated
     */
    public UmbrellaUserExample limit(Integer offset, Integer rows) {
        this.offset = offset;
        this.rows = rows;
        return this;
    }

    /**
     * @mbg.generated
     */
    public UmbrellaUserExample page(Integer page, Integer pageSize) {
        this.offset = page * pageSize;
        this.rows = pageSize;
        return this;
    }

    /**
     * <p>此类对应表 umbrella_user</p>
     *
     * <p>此类由 MyBatis Generator 生成</p>
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("id = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("id <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("id > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("id >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("id < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("id <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("name = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("name <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("name > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("name >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("name < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("name <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("nick_name = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("nick_name <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("nick_name > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("nick_name >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("nick_name < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("nick_name <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("phone = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("phone <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("phone > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("phone >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("phone < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("phone <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andAvtorIsNull() {
            addCriterion("avtor is null");
            return (Criteria) this;
        }

        public Criteria andAvtorIsNotNull() {
            addCriterion("avtor is not null");
            return (Criteria) this;
        }

        public Criteria andAvtorEqualTo(String value) {
            addCriterion("avtor =", value, "avtor");
            return (Criteria) this;
        }

        public Criteria andAvtorEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("avtor = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAvtorNotEqualTo(String value) {
            addCriterion("avtor <>", value, "avtor");
            return (Criteria) this;
        }

        public Criteria andAvtorNotEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("avtor <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAvtorGreaterThan(String value) {
            addCriterion("avtor >", value, "avtor");
            return (Criteria) this;
        }

        public Criteria andAvtorGreaterThanColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("avtor > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAvtorGreaterThanOrEqualTo(String value) {
            addCriterion("avtor >=", value, "avtor");
            return (Criteria) this;
        }

        public Criteria andAvtorGreaterThanOrEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("avtor >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAvtorLessThan(String value) {
            addCriterion("avtor <", value, "avtor");
            return (Criteria) this;
        }

        public Criteria andAvtorLessThanColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("avtor < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAvtorLessThanOrEqualTo(String value) {
            addCriterion("avtor <=", value, "avtor");
            return (Criteria) this;
        }

        public Criteria andAvtorLessThanOrEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("avtor <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andAvtorLike(String value) {
            addCriterion("avtor like", value, "avtor");
            return (Criteria) this;
        }

        public Criteria andAvtorNotLike(String value) {
            addCriterion("avtor not like", value, "avtor");
            return (Criteria) this;
        }

        public Criteria andAvtorIn(List<String> values) {
            addCriterion("avtor in", values, "avtor");
            return (Criteria) this;
        }

        public Criteria andAvtorNotIn(List<String> values) {
            addCriterion("avtor not in", values, "avtor");
            return (Criteria) this;
        }

        public Criteria andAvtorBetween(String value1, String value2) {
            addCriterion("avtor between", value1, value2, "avtor");
            return (Criteria) this;
        }

        public Criteria andAvtorNotBetween(String value1, String value2) {
            addCriterion("avtor not between", value1, value2, "avtor");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("email = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("email <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("email > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("email >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("email < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("email <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNull() {
            addCriterion("create_at is null");
            return (Criteria) this;
        }

        public Criteria andCreateAtIsNotNull() {
            addCriterion("create_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreateAtEqualTo(Date value) {
            addCriterion("create_at =", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("create_at = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateAtNotEqualTo(Date value) {
            addCriterion("create_at <>", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("create_at <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThan(Date value) {
            addCriterion("create_at >", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThanColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("create_at > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("create_at >=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtGreaterThanOrEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("create_at >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThan(Date value) {
            addCriterion("create_at <", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThanColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("create_at < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThanOrEqualTo(Date value) {
            addCriterion("create_at <=", value, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtLessThanOrEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("create_at <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andCreateAtIn(List<Date> values) {
            addCriterion("create_at in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotIn(List<Date> values) {
            addCriterion("create_at not in", values, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtBetween(Date value1, Date value2) {
            addCriterion("create_at between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andCreateAtNotBetween(Date value1, Date value2) {
            addCriterion("create_at not between", value1, value2, "createAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNull() {
            addCriterion("update_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtIsNotNull() {
            addCriterion("update_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateAtEqualTo(Date value) {
            addCriterion("update_at =", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("update_at = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotEqualTo(Date value) {
            addCriterion("update_at <>", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("update_at <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThan(Date value) {
            addCriterion("update_at >", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThanColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("update_at > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThanOrEqualTo(Date value) {
            addCriterion("update_at >=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtGreaterThanOrEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("update_at >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThan(Date value) {
            addCriterion("update_at <", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThanColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("update_at < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThanOrEqualTo(Date value) {
            addCriterion("update_at <=", value, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtLessThanOrEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("update_at <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andUpdateAtIn(List<Date> values) {
            addCriterion("update_at in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotIn(List<Date> values) {
            addCriterion("update_at not in", values, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtBetween(Date value1, Date value2) {
            addCriterion("update_at between", value1, value2, "updateAt");
            return (Criteria) this;
        }

        public Criteria andUpdateAtNotBetween(Date value1, Date value2) {
            addCriterion("update_at not between", value1, value2, "updateAt");
            return (Criteria) this;
        }

        public Criteria andDeleteAtIsNull() {
            addCriterion("delete_at is null");
            return (Criteria) this;
        }

        public Criteria andDeleteAtIsNotNull() {
            addCriterion("delete_at is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteAtEqualTo(Date value) {
            addCriterion("delete_at =", value, "deleteAt");
            return (Criteria) this;
        }

        public Criteria andDeleteAtEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("delete_at = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeleteAtNotEqualTo(Date value) {
            addCriterion("delete_at <>", value, "deleteAt");
            return (Criteria) this;
        }

        public Criteria andDeleteAtNotEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("delete_at <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeleteAtGreaterThan(Date value) {
            addCriterion("delete_at >", value, "deleteAt");
            return (Criteria) this;
        }

        public Criteria andDeleteAtGreaterThanColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("delete_at > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeleteAtGreaterThanOrEqualTo(Date value) {
            addCriterion("delete_at >=", value, "deleteAt");
            return (Criteria) this;
        }

        public Criteria andDeleteAtGreaterThanOrEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("delete_at >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeleteAtLessThan(Date value) {
            addCriterion("delete_at <", value, "deleteAt");
            return (Criteria) this;
        }

        public Criteria andDeleteAtLessThanColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("delete_at < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeleteAtLessThanOrEqualTo(Date value) {
            addCriterion("delete_at <=", value, "deleteAt");
            return (Criteria) this;
        }

        public Criteria andDeleteAtLessThanOrEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("delete_at <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDeleteAtIn(List<Date> values) {
            addCriterion("delete_at in", values, "deleteAt");
            return (Criteria) this;
        }

        public Criteria andDeleteAtNotIn(List<Date> values) {
            addCriterion("delete_at not in", values, "deleteAt");
            return (Criteria) this;
        }

        public Criteria andDeleteAtBetween(Date value1, Date value2) {
            addCriterion("delete_at between", value1, value2, "deleteAt");
            return (Criteria) this;
        }

        public Criteria andDeleteAtNotBetween(Date value1, Date value2) {
            addCriterion("delete_at not between", value1, value2, "deleteAt");
            return (Criteria) this;
        }

        public Criteria andDelIsNull() {
            addCriterion("del is null");
            return (Criteria) this;
        }

        public Criteria andDelIsNotNull() {
            addCriterion("del is not null");
            return (Criteria) this;
        }

        public Criteria andDelEqualTo(Boolean value) {
            addCriterion("del =", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("del = ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDelNotEqualTo(Boolean value) {
            addCriterion("del <>", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("del <> ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDelGreaterThan(Boolean value) {
            addCriterion("del >", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThanColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("del > ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDelGreaterThanOrEqualTo(Boolean value) {
            addCriterion("del >=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelGreaterThanOrEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("del >= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDelLessThan(Boolean value) {
            addCriterion("del <", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThanColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("del < ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDelLessThanOrEqualTo(Boolean value) {
            addCriterion("del <=", value, "del");
            return (Criteria) this;
        }

        public Criteria andDelLessThanOrEqualToColumn(UmbrellaUser.Column column) {
            addCriterion(new StringBuilder("del <= ").append(column.getEscapedColumnName()).toString());
            return (Criteria) this;
        }

        public Criteria andDelIn(List<Boolean> values) {
            addCriterion("del in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotIn(List<Boolean> values) {
            addCriterion("del not in", values, "del");
            return (Criteria) this;
        }

        public Criteria andDelBetween(Boolean value1, Boolean value2) {
            addCriterion("del between", value1, value2, "del");
            return (Criteria) this;
        }

        public Criteria andDelNotBetween(Boolean value1, Boolean value2) {
            addCriterion("del not between", value1, value2, "del");
            return (Criteria) this;
        }
    }

    /**
     * <p>此类对应表 umbrella_user</p>
     *
     * <p>此类由 MyBatis Generator 生成</p>
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {
        /**
         * @mbg.generated
         */
        private UmbrellaUserExample example;

        /**
         * @mbg.generated
         */
        protected Criteria(UmbrellaUserExample example) {
            super();
            this.example = example;
        }

        /**
         * @mbg.generated
         */
        public UmbrellaUserExample example() {
            return this.example;
        }

        /**
         * @mbg.generated
         */
        public Criteria when(boolean condition, ICriteriaWhen then) {
            if (condition) {
                then.criteria(this);
            }
            return this;
        }

        /**
         * @mbg.generated
         */
        public Criteria when(boolean condition, ICriteriaWhen then, ICriteriaWhen otherwise) {
            if (condition) {
                then.criteria(this);
            } else {
                otherwise.criteria(this);
            }
            return this;
        }

        /**
         * @mbg.generated
         */
        public Criteria andLogicalDeleted(boolean deleted) {
            return deleted ? andDelEqualTo(UmbrellaUser.Del.IS_DELETED.value()) : andDelNotEqualTo(UmbrellaUser.Del.IS_DELETED.value());
        }
    }

    /**
     * <p>此类对应表 umbrella_user</p>
     *
     * <p>此类由 MyBatis Generator 生成</p>
     * @mbg.generated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }

    /**
     * <p>此接口对应表 umbrella_user</p>
     *
     * <p>此接口由 MyBatis Generator 生成</p>
     * @mbg.generated
     */
    public interface ICriteriaWhen {
        /**
         * @mbg.generated
         */
        void criteria(Criteria criteria);
    }

    /**
     * <p>此接口对应表 umbrella_user</p>
     *
     * <p>此接口由 MyBatis Generator 生成</p>
     * @mbg.generated
     */
    public interface IExampleWhen {
        /**
         * @mbg.generated
         */
        void example(com.umbrella.base.entity.example.UmbrellaUserExample example);
    }
}