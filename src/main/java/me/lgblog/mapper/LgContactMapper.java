package me.lgblog.mapper;

import java.util.List;
import me.lgblog.pojo.LgContact;
import me.lgblog.pojo.LgContactExample;
import org.apache.ibatis.annotations.Param;

public interface LgContactMapper {
    int countByExample(LgContactExample example);

    int deleteByExample(LgContactExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LgContact record);

    int insertSelective(LgContact record);

    List<LgContact> selectByExampleWithBLOBs(LgContactExample example);

    List<LgContact> selectByExample(LgContactExample example);

    LgContact selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LgContact record, @Param("example") LgContactExample example);

    int updateByExampleWithBLOBs(@Param("record") LgContact record, @Param("example") LgContactExample example);

    int updateByExample(@Param("record") LgContact record, @Param("example") LgContactExample example);

    int updateByPrimaryKeySelective(LgContact record);

    int updateByPrimaryKeyWithBLOBs(LgContact record);

    int updateByPrimaryKey(LgContact record);
}