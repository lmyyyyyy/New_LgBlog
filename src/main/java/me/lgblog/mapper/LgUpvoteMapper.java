package me.lgblog.mapper;

import java.util.List;
import me.lgblog.pojo.LgUpvote;
import me.lgblog.pojo.LgUpvoteExample;
import org.apache.ibatis.annotations.Param;

public interface LgUpvoteMapper {
    int countByExample(LgUpvoteExample example);

    int deleteByExample(LgUpvoteExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LgUpvote record);

    int insertSelective(LgUpvote record);

    List<LgUpvote> selectByExample(LgUpvoteExample example);

    LgUpvote selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LgUpvote record, @Param("example") LgUpvoteExample example);

    int updateByExample(@Param("record") LgUpvote record, @Param("example") LgUpvoteExample example);

    int updateByPrimaryKeySelective(LgUpvote record);

    int updateByPrimaryKey(LgUpvote record);
}