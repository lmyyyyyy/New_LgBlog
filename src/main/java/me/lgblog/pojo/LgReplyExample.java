package me.lgblog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LgReplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LgReplyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andReplyUsernameIsNull() {
            addCriterion("reply_userName is null");
            return (Criteria) this;
        }

        public Criteria andReplyUsernameIsNotNull() {
            addCriterion("reply_userName is not null");
            return (Criteria) this;
        }

        public Criteria andReplyUsernameEqualTo(String value) {
            addCriterion("reply_userName =", value, "replyUsername");
            return (Criteria) this;
        }

        public Criteria andReplyUsernameNotEqualTo(String value) {
            addCriterion("reply_userName <>", value, "replyUsername");
            return (Criteria) this;
        }

        public Criteria andReplyUsernameGreaterThan(String value) {
            addCriterion("reply_userName >", value, "replyUsername");
            return (Criteria) this;
        }

        public Criteria andReplyUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("reply_userName >=", value, "replyUsername");
            return (Criteria) this;
        }

        public Criteria andReplyUsernameLessThan(String value) {
            addCriterion("reply_userName <", value, "replyUsername");
            return (Criteria) this;
        }

        public Criteria andReplyUsernameLessThanOrEqualTo(String value) {
            addCriterion("reply_userName <=", value, "replyUsername");
            return (Criteria) this;
        }

        public Criteria andReplyUsernameLike(String value) {
            addCriterion("reply_userName like", value, "replyUsername");
            return (Criteria) this;
        }

        public Criteria andReplyUsernameNotLike(String value) {
            addCriterion("reply_userName not like", value, "replyUsername");
            return (Criteria) this;
        }

        public Criteria andReplyUsernameIn(List<String> values) {
            addCriterion("reply_userName in", values, "replyUsername");
            return (Criteria) this;
        }

        public Criteria andReplyUsernameNotIn(List<String> values) {
            addCriterion("reply_userName not in", values, "replyUsername");
            return (Criteria) this;
        }

        public Criteria andReplyUsernameBetween(String value1, String value2) {
            addCriterion("reply_userName between", value1, value2, "replyUsername");
            return (Criteria) this;
        }

        public Criteria andReplyUsernameNotBetween(String value1, String value2) {
            addCriterion("reply_userName not between", value1, value2, "replyUsername");
            return (Criteria) this;
        }

        public Criteria andReplyEmailIsNull() {
            addCriterion("reply_email is null");
            return (Criteria) this;
        }

        public Criteria andReplyEmailIsNotNull() {
            addCriterion("reply_email is not null");
            return (Criteria) this;
        }

        public Criteria andReplyEmailEqualTo(String value) {
            addCriterion("reply_email =", value, "replyEmail");
            return (Criteria) this;
        }

        public Criteria andReplyEmailNotEqualTo(String value) {
            addCriterion("reply_email <>", value, "replyEmail");
            return (Criteria) this;
        }

        public Criteria andReplyEmailGreaterThan(String value) {
            addCriterion("reply_email >", value, "replyEmail");
            return (Criteria) this;
        }

        public Criteria andReplyEmailGreaterThanOrEqualTo(String value) {
            addCriterion("reply_email >=", value, "replyEmail");
            return (Criteria) this;
        }

        public Criteria andReplyEmailLessThan(String value) {
            addCriterion("reply_email <", value, "replyEmail");
            return (Criteria) this;
        }

        public Criteria andReplyEmailLessThanOrEqualTo(String value) {
            addCriterion("reply_email <=", value, "replyEmail");
            return (Criteria) this;
        }

        public Criteria andReplyEmailLike(String value) {
            addCriterion("reply_email like", value, "replyEmail");
            return (Criteria) this;
        }

        public Criteria andReplyEmailNotLike(String value) {
            addCriterion("reply_email not like", value, "replyEmail");
            return (Criteria) this;
        }

        public Criteria andReplyEmailIn(List<String> values) {
            addCriterion("reply_email in", values, "replyEmail");
            return (Criteria) this;
        }

        public Criteria andReplyEmailNotIn(List<String> values) {
            addCriterion("reply_email not in", values, "replyEmail");
            return (Criteria) this;
        }

        public Criteria andReplyEmailBetween(String value1, String value2) {
            addCriterion("reply_email between", value1, value2, "replyEmail");
            return (Criteria) this;
        }

        public Criteria andReplyEmailNotBetween(String value1, String value2) {
            addCriterion("reply_email not between", value1, value2, "replyEmail");
            return (Criteria) this;
        }

        public Criteria andReplyWebsiteIsNull() {
            addCriterion("reply_website is null");
            return (Criteria) this;
        }

        public Criteria andReplyWebsiteIsNotNull() {
            addCriterion("reply_website is not null");
            return (Criteria) this;
        }

        public Criteria andReplyWebsiteEqualTo(String value) {
            addCriterion("reply_website =", value, "replyWebsite");
            return (Criteria) this;
        }

        public Criteria andReplyWebsiteNotEqualTo(String value) {
            addCriterion("reply_website <>", value, "replyWebsite");
            return (Criteria) this;
        }

        public Criteria andReplyWebsiteGreaterThan(String value) {
            addCriterion("reply_website >", value, "replyWebsite");
            return (Criteria) this;
        }

        public Criteria andReplyWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("reply_website >=", value, "replyWebsite");
            return (Criteria) this;
        }

        public Criteria andReplyWebsiteLessThan(String value) {
            addCriterion("reply_website <", value, "replyWebsite");
            return (Criteria) this;
        }

        public Criteria andReplyWebsiteLessThanOrEqualTo(String value) {
            addCriterion("reply_website <=", value, "replyWebsite");
            return (Criteria) this;
        }

        public Criteria andReplyWebsiteLike(String value) {
            addCriterion("reply_website like", value, "replyWebsite");
            return (Criteria) this;
        }

        public Criteria andReplyWebsiteNotLike(String value) {
            addCriterion("reply_website not like", value, "replyWebsite");
            return (Criteria) this;
        }

        public Criteria andReplyWebsiteIn(List<String> values) {
            addCriterion("reply_website in", values, "replyWebsite");
            return (Criteria) this;
        }

        public Criteria andReplyWebsiteNotIn(List<String> values) {
            addCriterion("reply_website not in", values, "replyWebsite");
            return (Criteria) this;
        }

        public Criteria andReplyWebsiteBetween(String value1, String value2) {
            addCriterion("reply_website between", value1, value2, "replyWebsite");
            return (Criteria) this;
        }

        public Criteria andReplyWebsiteNotBetween(String value1, String value2) {
            addCriterion("reply_website not between", value1, value2, "replyWebsite");
            return (Criteria) this;
        }

        public Criteria andReplyCreatetimeIsNull() {
            addCriterion("reply_createTime is null");
            return (Criteria) this;
        }

        public Criteria andReplyCreatetimeIsNotNull() {
            addCriterion("reply_createTime is not null");
            return (Criteria) this;
        }

        public Criteria andReplyCreatetimeEqualTo(Date value) {
            addCriterion("reply_createTime =", value, "replyCreatetime");
            return (Criteria) this;
        }

        public Criteria andReplyCreatetimeNotEqualTo(Date value) {
            addCriterion("reply_createTime <>", value, "replyCreatetime");
            return (Criteria) this;
        }

        public Criteria andReplyCreatetimeGreaterThan(Date value) {
            addCriterion("reply_createTime >", value, "replyCreatetime");
            return (Criteria) this;
        }

        public Criteria andReplyCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reply_createTime >=", value, "replyCreatetime");
            return (Criteria) this;
        }

        public Criteria andReplyCreatetimeLessThan(Date value) {
            addCriterion("reply_createTime <", value, "replyCreatetime");
            return (Criteria) this;
        }

        public Criteria andReplyCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("reply_createTime <=", value, "replyCreatetime");
            return (Criteria) this;
        }

        public Criteria andReplyCreatetimeIn(List<Date> values) {
            addCriterion("reply_createTime in", values, "replyCreatetime");
            return (Criteria) this;
        }

        public Criteria andReplyCreatetimeNotIn(List<Date> values) {
            addCriterion("reply_createTime not in", values, "replyCreatetime");
            return (Criteria) this;
        }

        public Criteria andReplyCreatetimeBetween(Date value1, Date value2) {
            addCriterion("reply_createTime between", value1, value2, "replyCreatetime");
            return (Criteria) this;
        }

        public Criteria andReplyCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("reply_createTime not between", value1, value2, "replyCreatetime");
            return (Criteria) this;
        }

        public Criteria andLgBlogIdIsNull() {
            addCriterion("lg_blog_id is null");
            return (Criteria) this;
        }

        public Criteria andLgBlogIdIsNotNull() {
            addCriterion("lg_blog_id is not null");
            return (Criteria) this;
        }

        public Criteria andLgBlogIdEqualTo(Integer value) {
            addCriterion("lg_blog_id =", value, "lgBlogId");
            return (Criteria) this;
        }

        public Criteria andLgBlogIdNotEqualTo(Integer value) {
            addCriterion("lg_blog_id <>", value, "lgBlogId");
            return (Criteria) this;
        }

        public Criteria andLgBlogIdGreaterThan(Integer value) {
            addCriterion("lg_blog_id >", value, "lgBlogId");
            return (Criteria) this;
        }

        public Criteria andLgBlogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("lg_blog_id >=", value, "lgBlogId");
            return (Criteria) this;
        }

        public Criteria andLgBlogIdLessThan(Integer value) {
            addCriterion("lg_blog_id <", value, "lgBlogId");
            return (Criteria) this;
        }

        public Criteria andLgBlogIdLessThanOrEqualTo(Integer value) {
            addCriterion("lg_blog_id <=", value, "lgBlogId");
            return (Criteria) this;
        }

        public Criteria andLgBlogIdIn(List<Integer> values) {
            addCriterion("lg_blog_id in", values, "lgBlogId");
            return (Criteria) this;
        }

        public Criteria andLgBlogIdNotIn(List<Integer> values) {
            addCriterion("lg_blog_id not in", values, "lgBlogId");
            return (Criteria) this;
        }

        public Criteria andLgBlogIdBetween(Integer value1, Integer value2) {
            addCriterion("lg_blog_id between", value1, value2, "lgBlogId");
            return (Criteria) this;
        }

        public Criteria andLgBlogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("lg_blog_id not between", value1, value2, "lgBlogId");
            return (Criteria) this;
        }

        public Criteria andReplyIpIsNull() {
            addCriterion("reply_ip is null");
            return (Criteria) this;
        }

        public Criteria andReplyIpIsNotNull() {
            addCriterion("reply_ip is not null");
            return (Criteria) this;
        }

        public Criteria andReplyIpEqualTo(String value) {
            addCriterion("reply_ip =", value, "replyIp");
            return (Criteria) this;
        }

        public Criteria andReplyIpNotEqualTo(String value) {
            addCriterion("reply_ip <>", value, "replyIp");
            return (Criteria) this;
        }

        public Criteria andReplyIpGreaterThan(String value) {
            addCriterion("reply_ip >", value, "replyIp");
            return (Criteria) this;
        }

        public Criteria andReplyIpGreaterThanOrEqualTo(String value) {
            addCriterion("reply_ip >=", value, "replyIp");
            return (Criteria) this;
        }

        public Criteria andReplyIpLessThan(String value) {
            addCriterion("reply_ip <", value, "replyIp");
            return (Criteria) this;
        }

        public Criteria andReplyIpLessThanOrEqualTo(String value) {
            addCriterion("reply_ip <=", value, "replyIp");
            return (Criteria) this;
        }

        public Criteria andReplyIpLike(String value) {
            addCriterion("reply_ip like", value, "replyIp");
            return (Criteria) this;
        }

        public Criteria andReplyIpNotLike(String value) {
            addCriterion("reply_ip not like", value, "replyIp");
            return (Criteria) this;
        }

        public Criteria andReplyIpIn(List<String> values) {
            addCriterion("reply_ip in", values, "replyIp");
            return (Criteria) this;
        }

        public Criteria andReplyIpNotIn(List<String> values) {
            addCriterion("reply_ip not in", values, "replyIp");
            return (Criteria) this;
        }

        public Criteria andReplyIpBetween(String value1, String value2) {
            addCriterion("reply_ip between", value1, value2, "replyIp");
            return (Criteria) this;
        }

        public Criteria andReplyIpNotBetween(String value1, String value2) {
            addCriterion("reply_ip not between", value1, value2, "replyIp");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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
}