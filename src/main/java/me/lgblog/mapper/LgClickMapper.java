package me.lgblog.mapper;

import java.util.List;
import me.lgblog.pojo.LgClick;
import me.lgblog.pojo.LgClickExample;
import org.apache.ibatis.annotations.Param;

public interface LgClickMapper {
    int countByExample(LgClickExample example);

    int deleteByExample(LgClickExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LgClick record);

    int insertSelective(LgClick record);

    List<LgClick> selectByExample(LgClickExample example);

    LgClick selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LgClick record, @Param("example") LgClickExample example);

    int updateByExample(@Param("record") LgClick record, @Param("example") LgClickExample example);

    int updateByPrimaryKeySelective(LgClick record);

    int updateByPrimaryKey(LgClick record);
}