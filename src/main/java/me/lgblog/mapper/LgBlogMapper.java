package me.lgblog.mapper;

import java.util.List;
import me.lgblog.pojo.LgBlog;
import me.lgblog.pojo.LgBlogExample;
import org.apache.ibatis.annotations.Param;

public interface LgBlogMapper {
    int countByExample(LgBlogExample example);

    int deleteByExample(LgBlogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LgBlog record);

    int insertSelective(LgBlog record);

    List<LgBlog> selectByExampleWithBLOBs(LgBlogExample example);

    List<LgBlog> selectByExample(LgBlogExample example);

    LgBlog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LgBlog record, @Param("example") LgBlogExample example);

    int updateByExampleWithBLOBs(@Param("record") LgBlog record, @Param("example") LgBlogExample example);

    int updateByExample(@Param("record") LgBlog record, @Param("example") LgBlogExample example);

    int updateByPrimaryKeySelective(LgBlog record);

    int updateByPrimaryKeyWithBLOBs(LgBlog record);

    int updateByPrimaryKey(LgBlog record);
}