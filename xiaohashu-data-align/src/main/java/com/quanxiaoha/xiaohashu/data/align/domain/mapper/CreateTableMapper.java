package com.quanxiaoha.xiaohashu.data.align.domain.mapper;

public interface CreateTableMapper {
    /**
     * 创建日增量表：关注数计数变更
     * @param tableNameSuffix
     */
    void createDataAlignFollowingCountTempTable(String tableNameSuffix);
}
