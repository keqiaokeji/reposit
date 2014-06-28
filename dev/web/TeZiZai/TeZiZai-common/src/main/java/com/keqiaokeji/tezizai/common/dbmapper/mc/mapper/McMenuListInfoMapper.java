package com.keqiaokeji.tezizai.common.dbmapper.mc.mapper;

import com.keqiaokeji.tezizai.common.dbmapper.mc.domain.McMenuListInfo;
import com.keqiaokeji.tezizai.common.dbmapper.mc.domain.McMenuListInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface McMenuListInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_menu_list_info
     *
     * @mbggenerated Sat Jun 28 12:17:52 CST 2014
     */
    int countByExample(McMenuListInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_menu_list_info
     *
     * @mbggenerated Sat Jun 28 12:17:52 CST 2014
     */
    int deleteByExample(McMenuListInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_menu_list_info
     *
     * @mbggenerated Sat Jun 28 12:17:52 CST 2014
     */
    int deleteByPrimaryKey(String menuListInfoId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_menu_list_info
     *
     * @mbggenerated Sat Jun 28 12:17:52 CST 2014
     */
    int insert(McMenuListInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_menu_list_info
     *
     * @mbggenerated Sat Jun 28 12:17:52 CST 2014
     */
    int insertSelective(McMenuListInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_menu_list_info
     *
     * @mbggenerated Sat Jun 28 12:17:52 CST 2014
     */
    List<McMenuListInfo> selectByExample(McMenuListInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_menu_list_info
     *
     * @mbggenerated Sat Jun 28 12:17:52 CST 2014
     */
    McMenuListInfo selectByPrimaryKey(String menuListInfoId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_menu_list_info
     *
     * @mbggenerated Sat Jun 28 12:17:52 CST 2014
     */
    int updateByExampleSelective(@Param("record") McMenuListInfo record, @Param("example") McMenuListInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_menu_list_info
     *
     * @mbggenerated Sat Jun 28 12:17:52 CST 2014
     */
    int updateByExample(@Param("record") McMenuListInfo record, @Param("example") McMenuListInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_menu_list_info
     *
     * @mbggenerated Sat Jun 28 12:17:52 CST 2014
     */
    int updateByPrimaryKeySelective(McMenuListInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_menu_list_info
     *
     * @mbggenerated Sat Jun 28 12:17:52 CST 2014
     */
    int updateByPrimaryKey(McMenuListInfo record);
}