package me.lgblog.mapper;

import java.util.List;
import me.lgblog.pojo.LgType;
import me.lgblog.pojo.LgTypeExample;
import org.apache.ibatis.annotations.Param;

public interface LgTypeMapper {
    int countByExample(LgTypeExample example);

    int deleteByExample(LgTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LgType record);

    int insertSelective(LgType record);

    List<LgType> selectByExample(LgTypeExample example);

    LgType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LgType record, @Param("example") LgTypeExample example);

    int updateByExample(@Param("record") LgType record, @Param("example") LgTypeExample example);

    int updateByPrimaryKeySelective(LgType record);

    int updateByPrimaryKey(LgType record);
}