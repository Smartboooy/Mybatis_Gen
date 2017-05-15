package com.github.Smartboooy.calendar.core.model.mapper;

import com.github.Smartboooy.calendar.core.model.pojo.WpsToken;
import com.github.Smartboooy.calendar.core.model.pojo.WpsTokenExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface WpsTokenMapper {
    int countByExample(WpsTokenExample example);

    int deleteByExample(WpsTokenExample example);

    @Delete({
        "delete from wps_token",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into wps_token (id, userid, ",
        "appid, expires_in, ",
        "access_token, refresh_token)",
        "values (#{id,jdbcType=BIGINT}, #{userid,jdbcType=BIGINT}, ",
        "#{appid,jdbcType=VARCHAR}, #{expiresIn,jdbcType=BIGINT}, ",
        "#{accessToken,jdbcType=VARCHAR}, #{refreshToken,jdbcType=VARCHAR})"
    })
    int insert(WpsToken record);

    int insertSelective(WpsToken record);

    List<WpsToken> selectByExample(WpsTokenExample example);

    @Select({
        "select",
        "id, userid, appid, expires_in, access_token, refresh_token",
        "from wps_token",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("BaseResultMap")
    WpsToken selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WpsToken record, @Param("example") WpsTokenExample example);

    int updateByExample(@Param("record") WpsToken record, @Param("example") WpsTokenExample example);

    int updateByPrimaryKeySelective(WpsToken record);

    @Update({
        "update wps_token",
        "set userid = #{userid,jdbcType=BIGINT},",
          "appid = #{appid,jdbcType=VARCHAR},",
          "expires_in = #{expiresIn,jdbcType=BIGINT},",
          "access_token = #{accessToken,jdbcType=VARCHAR},",
          "refresh_token = #{refreshToken,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(WpsToken record);
}