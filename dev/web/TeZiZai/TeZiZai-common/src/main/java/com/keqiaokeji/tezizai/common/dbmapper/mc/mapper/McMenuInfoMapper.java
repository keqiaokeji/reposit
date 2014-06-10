package com.keqiaokeji.tezizai.common.dbmapper.mc.mapper;

import com.keqiaokeji.tezizai.common.dbmapper.mc.domain.McMenuInfo;
import com.keqiaokeji.tezizai.common.dbmapper.mc.domain.McMenuInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface McMenuInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_menu_info
     *
     * @mbggenerated Tue Jun 10 23:05:55 CST 2014
     */
    int countByExample(McMenuInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_menu_info
     *
     * @mbggenerated Tue Jun 10 23:05:55 CST 2014
     */
    int deleteByExample(McMenuInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_menu_info
     *
     * @mbggenerated Tue Jun 10 23:05:55 CST 2014
     */
    int deleteByPrimaryKey(String menuId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_menu_info
     *
     * @mbggenerated Tue Jun 10 23:05:55 CST 2014
     */
    int insert(McMenuInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_menu_info
     *
     * @mbggenerated Tue Jun 10 23:05:55 CST 2014
     */
    int insertSelective(McMenuInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_menu_info
     *
     * @mbggenerated Tue Jun 10 23:05:55 CST 2014
     */
    List<McMenuInfo> selectByExample(McMenuInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_menu_info
     *
     * @mbggenerated Tue Jun 10 23:05:55 CST 2014
     */
    McMenuInfo selectByPrimaryKey(String menuId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_menu_info
     *
     * @mbggenerated Tue Jun 10 23:05:55 CST 2014
     */
    int updateByExampleSelective(@Param("record") McMenuInfo record, @Param("example") McMenuInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_menu_info
     *
     * @mbggenerated Tue Jun 10 23:05:55 CST 2014
     */
    int updateByExample(@Param("record") McMenuInfo record, @Param("example") McMenuInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_menu_info
     *
     * @mbggenerated Tue Jun 10 23:05:55 CST 2014
     */
    int updateByPrimaryKeySelective(McMenuInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_menu_info
     *
     * @mbggenerated Tue Jun 10 23:05:55 CST 2014
     */
    int updateByPrimaryKey(McMenuInfo record);
}