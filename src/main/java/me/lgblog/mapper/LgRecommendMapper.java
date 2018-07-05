package me.lgblog.mapper;

import java.util.List;
import me.lgblog.pojo.LgRecommend;
import me.lgblog.pojo.LgRecommendExample;
import org.apache.ibatis.annotations.Param;

public interface LgRecommendMapper {
    int countByExample(LgRecommendExample example);

    int deleteByExample(LgRecommendExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LgRecommend record);

    int insertSelective(LgRecommend record);

    List<LgRecommend> selectByExample(LgRecommendExample example);

    LgRecommend selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LgRecommend record, @Param("example") LgRecommendExample example);

    int updateByExample(@Param("record") LgRecommend record, @Param("example") LgRecommendExample example);

    int updateByPrimaryKeySelective(LgRecommend record);

    int updateByPrimaryKey(LgRecommend record);
}