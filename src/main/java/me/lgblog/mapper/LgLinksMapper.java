package me.lgblog.mapper;

import java.util.List;
import me.lgblog.pojo.LgLinks;
import me.lgblog.pojo.LgLinksExample;
import org.apache.ibatis.annotations.Param;

public interface LgLinksMapper {
    int countByExample(LgLinksExample example);

    int deleteByExample(LgLinksExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LgLinks record);

    int insertSelective(LgLinks record);

    List<LgLinks> selectByExample(LgLinksExample example);

    LgLinks selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LgLinks record, @Param("example") LgLinksExample example);

    int updateByExample(@Param("record") LgLinks record, @Param("example") LgLinksExample example);

    int updateByPrimaryKeySelective(LgLinks record);

    int updateByPrimaryKey(LgLinks record);
}