package com.keqiaokeji.tezizai.common.character;

import org.apache.log4j.Logger;

/**
 * Created by shk on 14-6-26.
 */
public class DbSqlUtils {

    private String sqlWhere;

    private String sqlOption;

    private String sqlData;

    private String sqlCount;

    Logger logger = Logger.getLogger(DbSqlUtils.class.getName());

    //采用正则表达式将包含有 单引号(')，分号(;) 和 注释符号(--)的语句给替换掉来防止SQL注入
    public static String TransactSQLInjection(String str) {
        return str.replaceAll(".*([';]+|(--)+).*", " ");
        // 我认为 应该是return str.replaceAll("([';])+|(--)+","");
    }


    public String getSqlWhere() {
        return sqlWhere;
    }

    public void setSqlWhere(String sqlWhere) {
        this.sqlWhere = sqlWhere;
    }

    public String getSqlOption() {
        return sqlOption;
    }

    public void setSqlOption(String sqlOption) {
        this.sqlOption = sqlOption;
    }

    public String getSqlData() {
        sqlData = sqlData + sqlWhere + sqlOption;
        logger.debug("执行sql：" + sqlData);
        return sqlData;
    }

    public void setSqlData(String sqlData) {
        this.sqlData = sqlData;
    }

    public String getSqlCount() {
        sqlCount = sqlCount + sqlWhere;
        logger.debug("执行sql：" + sqlWhere);
        return sqlCount;
    }

    public void setSqlCount(String sqlCount) {
        this.sqlCount = sqlCount;
    }
}
