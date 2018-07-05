package me.lgblog.mapper;

import java.util.List;
import me.lgblog.pojo.LgReply;
import me.lgblog.pojo.LgReplyExample;
import org.apache.ibatis.annotations.Param;

public interface LgReplyMapper {
    int countByExample(LgReplyExample example);

    int deleteByExample(LgReplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LgReply record);

    int insertSelective(LgReply record);

    List<LgReply> selectByExampleWithBLOBs(LgReplyExample example);

    List<LgReply> selectByExample(LgReplyExample example);

    LgReply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LgReply record, @Param("example") LgReplyExample example);

    int updateByExampleWithBLOBs(@Param("record") LgReply record, @Param("example") LgReplyExample example);

    int updateByExample(@Param("record") LgReply record, @Param("example") LgReplyExample example);

    int updateByPrimaryKeySelective(LgReply record);

    int updateByPrimaryKeyWithBLOBs(LgReply record);

    int updateByPrimaryKey(LgReply record);
}