package me.lgblog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LgBlogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LgBlogExample() {
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

        public Criteria andBlogTitleIsNull() {
            addCriterion("blog_title is null");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIsNotNull() {
            addCriterion("blog_title is not null");
            return (Criteria) this;
        }

        public Criteria andBlogTitleEqualTo(String value) {
            addCriterion("blog_title =", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotEqualTo(String value) {
            addCriterion("blog_title <>", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleGreaterThan(String value) {
            addCriterion("blog_title >", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleGreaterThanOrEqualTo(String value) {
            addCriterion("blog_title >=", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLessThan(String value) {
            addCriterion("blog_title <", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLessThanOrEqualTo(String value) {
            addCriterion("blog_title <=", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleLike(String value) {
            addCriterion("blog_title like", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotLike(String value) {
            addCriterion("blog_title not like", value, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleIn(List<String> values) {
            addCriterion("blog_title in", values, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotIn(List<String> values) {
            addCriterion("blog_title not in", values, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleBetween(String value1, String value2) {
            addCriterion("blog_title between", value1, value2, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogTitleNotBetween(String value1, String value2) {
            addCriterion("blog_title not between", value1, value2, "blogTitle");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorIsNull() {
            addCriterion("blog_author is null");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorIsNotNull() {
            addCriterion("blog_author is not null");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorEqualTo(String value) {
            addCriterion("blog_author =", value, "blogAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorNotEqualTo(String value) {
            addCriterion("blog_author <>", value, "blogAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorGreaterThan(String value) {
            addCriterion("blog_author >", value, "blogAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("blog_author >=", value, "blogAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorLessThan(String value) {
            addCriterion("blog_author <", value, "blogAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorLessThanOrEqualTo(String value) {
            addCriterion("blog_author <=", value, "blogAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorLike(String value) {
            addCriterion("blog_author like", value, "blogAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorNotLike(String value) {
            addCriterion("blog_author not like", value, "blogAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorIn(List<String> values) {
            addCriterion("blog_author in", values, "blogAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorNotIn(List<String> values) {
            addCriterion("blog_author not in", values, "blogAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorBetween(String value1, String value2) {
            addCriterion("blog_author between", value1, value2, "blogAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogAuthorNotBetween(String value1, String value2) {
            addCriterion("blog_author not between", value1, value2, "blogAuthor");
            return (Criteria) this;
        }

        public Criteria andBlogPictureIsNull() {
            addCriterion("blog_picture is null");
            return (Criteria) this;
        }

        public Criteria andBlogPictureIsNotNull() {
            addCriterion("blog_picture is not null");
            return (Criteria) this;
        }

        public Criteria andBlogPictureEqualTo(String value) {
            addCriterion("blog_picture =", value, "blogPicture");
            return (Criteria) this;
        }

        public Criteria andBlogPictureNotEqualTo(String value) {
            addCriterion("blog_picture <>", value, "blogPicture");
            return (Criteria) this;
        }

        public Criteria andBlogPictureGreaterThan(String value) {
            addCriterion("blog_picture >", value, "blogPicture");
            return (Criteria) this;
        }

        public Criteria andBlogPictureGreaterThanOrEqualTo(String value) {
            addCriterion("blog_picture >=", value, "blogPicture");
            return (Criteria) this;
        }

        public Criteria andBlogPictureLessThan(String value) {
            addCriterion("blog_picture <", value, "blogPicture");
            return (Criteria) this;
        }

        public Criteria andBlogPictureLessThanOrEqualTo(String value) {
            addCriterion("blog_picture <=", value, "blogPicture");
            return (Criteria) this;
        }

        public Criteria andBlogPictureLike(String value) {
            addCriterion("blog_picture like", value, "blogPicture");
            return (Criteria) this;
        }

        public Criteria andBlogPictureNotLike(String value) {
            addCriterion("blog_picture not like", value, "blogPicture");
            return (Criteria) this;
        }

        public Criteria andBlogPictureIn(List<String> values) {
            addCriterion("blog_picture in", values, "blogPicture");
            return (Criteria) this;
        }

        public Criteria andBlogPictureNotIn(List<String> values) {
            addCriterion("blog_picture not in", values, "blogPicture");
            return (Criteria) this;
        }

        public Criteria andBlogPictureBetween(String value1, String value2) {
            addCriterion("blog_picture between", value1, value2, "blogPicture");
            return (Criteria) this;
        }

        public Criteria andBlogPictureNotBetween(String value1, String value2) {
            addCriterion("blog_picture not between", value1, value2, "blogPicture");
            return (Criteria) this;
        }

        public Criteria andBlogTypeIsNull() {
            addCriterion("blog_type is null");
            return (Criteria) this;
        }

        public Criteria andBlogTypeIsNotNull() {
            addCriterion("blog_type is not null");
            return (Criteria) this;
        }

        public Criteria andBlogTypeEqualTo(String value) {
            addCriterion("blog_type =", value, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeNotEqualTo(String value) {
            addCriterion("blog_type <>", value, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeGreaterThan(String value) {
            addCriterion("blog_type >", value, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeGreaterThanOrEqualTo(String value) {
            addCriterion("blog_type >=", value, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeLessThan(String value) {
            addCriterion("blog_type <", value, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeLessThanOrEqualTo(String value) {
            addCriterion("blog_type <=", value, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeLike(String value) {
            addCriterion("blog_type like", value, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeNotLike(String value) {
            addCriterion("blog_type not like", value, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeIn(List<String> values) {
            addCriterion("blog_type in", values, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeNotIn(List<String> values) {
            addCriterion("blog_type not in", values, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeBetween(String value1, String value2) {
            addCriterion("blog_type between", value1, value2, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogTypeNotBetween(String value1, String value2) {
            addCriterion("blog_type not between", value1, value2, "blogType");
            return (Criteria) this;
        }

        public Criteria andBlogDescIsNull() {
            addCriterion("blog_desc is null");
            return (Criteria) this;
        }

        public Criteria andBlogDescIsNotNull() {
            addCriterion("blog_desc is not null");
            return (Criteria) this;
        }

        public Criteria andBlogDescEqualTo(String value) {
            addCriterion("blog_desc =", value, "blogDesc");
            return (Criteria) this;
        }

        public Criteria andBlogDescNotEqualTo(String value) {
            addCriterion("blog_desc <>", value, "blogDesc");
            return (Criteria) this;
        }

        public Criteria andBlogDescGreaterThan(String value) {
            addCriterion("blog_desc >", value, "blogDesc");
            return (Criteria) this;
        }

        public Criteria andBlogDescGreaterThanOrEqualTo(String value) {
            addCriterion("blog_desc >=", value, "blogDesc");
            return (Criteria) this;
        }

        public Criteria andBlogDescLessThan(String value) {
            addCriterion("blog_desc <", value, "blogDesc");
            return (Criteria) this;
        }

        public Criteria andBlogDescLessThanOrEqualTo(String value) {
            addCriterion("blog_desc <=", value, "blogDesc");
            return (Criteria) this;
        }

        public Criteria andBlogDescLike(String value) {
            addCriterion("blog_desc like", value, "blogDesc");
            return (Criteria) this;
        }

        public Criteria andBlogDescNotLike(String value) {
            addCriterion("blog_desc not like", value, "blogDesc");
            return (Criteria) this;
        }

        public Criteria andBlogDescIn(List<String> values) {
            addCriterion("blog_desc in", values, "blogDesc");
            return (Criteria) this;
        }

        public Criteria andBlogDescNotIn(List<String> values) {
            addCriterion("blog_desc not in", values, "blogDesc");
            return (Criteria) this;
        }

        public Criteria andBlogDescBetween(String value1, String value2) {
            addCriterion("blog_desc between", value1, value2, "blogDesc");
            return (Criteria) this;
        }

        public Criteria andBlogDescNotBetween(String value1, String value2) {
            addCriterion("blog_desc not between", value1, value2, "blogDesc");
            return (Criteria) this;
        }

        public Criteria andBlogCreatetimeIsNull() {
            addCriterion("blog_createTime is null");
            return (Criteria) this;
        }

        public Criteria andBlogCreatetimeIsNotNull() {
            addCriterion("blog_createTime is not null");
            return (Criteria) this;
        }

        public Criteria andBlogCreatetimeEqualTo(Date value) {
            addCriterion("blog_createTime =", value, "blogCreatetime");
            return (Criteria) this;
        }

        public Criteria andBlogCreatetimeNotEqualTo(Date value) {
            addCriterion("blog_createTime <>", value, "blogCreatetime");
            return (Criteria) this;
        }

        public Criteria andBlogCreatetimeGreaterThan(Date value) {
            addCriterion("blog_createTime >", value, "blogCreatetime");
            return (Criteria) this;
        }

        public Criteria andBlogCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("blog_createTime >=", value, "blogCreatetime");
            return (Criteria) this;
        }

        public Criteria andBlogCreatetimeLessThan(Date value) {
            addCriterion("blog_createTime <", value, "blogCreatetime");
            return (Criteria) this;
        }

        public Criteria andBlogCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("blog_createTime <=", value, "blogCreatetime");
            return (Criteria) this;
        }

        public Criteria andBlogCreatetimeIn(List<Date> values) {
            addCriterion("blog_createTime in", values, "blogCreatetime");
            return (Criteria) this;
        }

        public Criteria andBlogCreatetimeNotIn(List<Date> values) {
            addCriterion("blog_createTime not in", values, "blogCreatetime");
            return (Criteria) this;
        }

        public Criteria andBlogCreatetimeBetween(Date value1, Date value2) {
            addCriterion("blog_createTime between", value1, value2, "blogCreatetime");
            return (Criteria) this;
        }

        public Criteria andBlogCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("blog_createTime not between", value1, value2, "blogCreatetime");
            return (Criteria) this;
        }

        public Criteria andBlogReplyCountIsNull() {
            addCriterion("blog_reply_count is null");
            return (Criteria) this;
        }

        public Criteria andBlogReplyCountIsNotNull() {
            addCriterion("blog_reply_count is not null");
            return (Criteria) this;
        }

        public Criteria andBlogReplyCountEqualTo(Integer value) {
            addCriterion("blog_reply_count =", value, "blogReplyCount");
            return (Criteria) this;
        }

        public Criteria andBlogReplyCountNotEqualTo(Integer value) {
            addCriterion("blog_reply_count <>", value, "blogReplyCount");
            return (Criteria) this;
        }

        public Criteria andBlogReplyCountGreaterThan(Integer value) {
            addCriterion("blog_reply_count >", value, "blogReplyCount");
            return (Criteria) this;
        }

        public Criteria andBlogReplyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_reply_count >=", value, "blogReplyCount");
            return (Criteria) this;
        }

        public Criteria andBlogReplyCountLessThan(Integer value) {
            addCriterion("blog_reply_count <", value, "blogReplyCount");
            return (Criteria) this;
        }

        public Criteria andBlogReplyCountLessThanOrEqualTo(Integer value) {
            addCriterion("blog_reply_count <=", value, "blogReplyCount");
            return (Criteria) this;
        }

        public Criteria andBlogReplyCountIn(List<Integer> values) {
            addCriterion("blog_reply_count in", values, "blogReplyCount");
            return (Criteria) this;
        }

        public Criteria andBlogReplyCountNotIn(List<Integer> values) {
            addCriterion("blog_reply_count not in", values, "blogReplyCount");
            return (Criteria) this;
        }

        public Criteria andBlogReplyCountBetween(Integer value1, Integer value2) {
            addCriterion("blog_reply_count between", value1, value2, "blogReplyCount");
            return (Criteria) this;
        }

        public Criteria andBlogReplyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_reply_count not between", value1, value2, "blogReplyCount");
            return (Criteria) this;
        }

        public Criteria andBlogUpvoteCountIsNull() {
            addCriterion("blog_upvote_count is null");
            return (Criteria) this;
        }

        public Criteria andBlogUpvoteCountIsNotNull() {
            addCriterion("blog_upvote_count is not null");
            return (Criteria) this;
        }

        public Criteria andBlogUpvoteCountEqualTo(Integer value) {
            addCriterion("blog_upvote_count =", value, "blogUpvoteCount");
            return (Criteria) this;
        }

        public Criteria andBlogUpvoteCountNotEqualTo(Integer value) {
            addCriterion("blog_upvote_count <>", value, "blogUpvoteCount");
            return (Criteria) this;
        }

        public Criteria andBlogUpvoteCountGreaterThan(Integer value) {
            addCriterion("blog_upvote_count >", value, "blogUpvoteCount");
            return (Criteria) this;
        }

        public Criteria andBlogUpvoteCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_upvote_count >=", value, "blogUpvoteCount");
            return (Criteria) this;
        }

        public Criteria andBlogUpvoteCountLessThan(Integer value) {
            addCriterion("blog_upvote_count <", value, "blogUpvoteCount");
            return (Criteria) this;
        }

        public Criteria andBlogUpvoteCountLessThanOrEqualTo(Integer value) {
            addCriterion("blog_upvote_count <=", value, "blogUpvoteCount");
            return (Criteria) this;
        }

        public Criteria andBlogUpvoteCountIn(List<Integer> values) {
            addCriterion("blog_upvote_count in", values, "blogUpvoteCount");
            return (Criteria) this;
        }

        public Criteria andBlogUpvoteCountNotIn(List<Integer> values) {
            addCriterion("blog_upvote_count not in", values, "blogUpvoteCount");
            return (Criteria) this;
        }

        public Criteria andBlogUpvoteCountBetween(Integer value1, Integer value2) {
            addCriterion("blog_upvote_count between", value1, value2, "blogUpvoteCount");
            return (Criteria) this;
        }

        public Criteria andBlogUpvoteCountNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_upvote_count not between", value1, value2, "blogUpvoteCount");
            return (Criteria) this;
        }

        public Criteria andBlogClickCountIsNull() {
            addCriterion("blog_click_count is null");
            return (Criteria) this;
        }

        public Criteria andBlogClickCountIsNotNull() {
            addCriterion("blog_click_count is not null");
            return (Criteria) this;
        }

        public Criteria andBlogClickCountEqualTo(Integer value) {
            addCriterion("blog_click_count =", value, "blogClickCount");
            return (Criteria) this;
        }

        public Criteria andBlogClickCountNotEqualTo(Integer value) {
            addCriterion("blog_click_count <>", value, "blogClickCount");
            return (Criteria) this;
        }

        public Criteria andBlogClickCountGreaterThan(Integer value) {
            addCriterion("blog_click_count >", value, "blogClickCount");
            return (Criteria) this;
        }

        public Criteria andBlogClickCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_click_count >=", value, "blogClickCount");
            return (Criteria) this;
        }

        public Criteria andBlogClickCountLessThan(Integer value) {
            addCriterion("blog_click_count <", value, "blogClickCount");
            return (Criteria) this;
        }

        public Criteria andBlogClickCountLessThanOrEqualTo(Integer value) {
            addCriterion("blog_click_count <=", value, "blogClickCount");
            return (Criteria) this;
        }

        public Criteria andBlogClickCountIn(List<Integer> values) {
            addCriterion("blog_click_count in", values, "blogClickCount");
            return (Criteria) this;
        }

        public Criteria andBlogClickCountNotIn(List<Integer> values) {
            addCriterion("blog_click_count not in", values, "blogClickCount");
            return (Criteria) this;
        }

        public Criteria andBlogClickCountBetween(Integer value1, Integer value2) {
            addCriterion("blog_click_count between", value1, value2, "blogClickCount");
            return (Criteria) this;
        }

        public Criteria andBlogClickCountNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_click_count not between", value1, value2, "blogClickCount");
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