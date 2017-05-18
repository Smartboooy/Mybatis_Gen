package com.github.ongz1992.calendar.core.model.mapper;

import com.github.ongz1992.calendar.core.model.pojo.Jdovalue;
import com.github.ongz1992.calendar.core.model.pojo.JdovalueExample;
import com.github.ongz1992.calendar.core.model.pojo.JdovalueKey;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface JdovalueMapper {
    int countByExample(JdovalueExample example);

    int deleteByExample(JdovalueExample example);

    @Delete({
        "delete from jdovalue",
        "where ID = #{id,jdbcType=VARCHAR}",
          "and KEY = #{key,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(JdovalueKey key);

    @Insert({
        "insert into jdovalue (ID, KEY, ",
        "BYTES)",
        "values (#{id,jdbcType=VARCHAR}, #{key,jdbcType=VARCHAR}, ",
        "#{bytes,jdbcType=LONGVARBINARY})"
    })
    int insert(Jdovalue record);

    int insertSelective(Jdovalue record);

    List<Jdovalue> selectByExampleWithBLOBs(JdovalueExample example);

    List<Jdovalue> selectByExample(JdovalueExample example);

    @Select({
        "select",
        "ID, KEY, BYTES",
        "from jdovalue",
        "where ID = #{id,jdbcType=VARCHAR}",
          "and KEY = #{key,jdbcType=VARCHAR}"
    })
    @ResultMap("ResultMapWithBLOBs")
    Jdovalue selectByPrimaryKey(JdovalueKey key);

    int updateByExampleSelective(@Param("record") Jdovalue record, @Param("example") JdovalueExample example);

    int updateByExampleWithBLOBs(@Param("record") Jdovalue record, @Param("example") JdovalueExample example);

    int updateByExample(@Param("record") Jdovalue record, @Param("example") JdovalueExample example);

    int updateByPrimaryKeySelective(Jdovalue record);

    @Update({
        "update jdovalue",
        "set BYTES = #{bytes,jdbcType=LONGVARBINARY}",
        "where ID = #{id,jdbcType=VARCHAR}",
          "and KEY = #{key,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKeyWithBLOBs(Jdovalue record);
}