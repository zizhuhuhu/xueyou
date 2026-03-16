package com.quanxiaoha.xiaohashu.data.align.job;

import com.quanxiaoha.xiaohashu.data.align.constants.TableConstants;
import com.quanxiaoha.xiaohashu.data.align.domain.mapper.CreateTableMapper;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CreateTableXxlJob {
    @Resource
    private CreateTableMapper createTableMapper;
    /**
     * 1、简单任务示例（Bean模式）
     */
    @XxlJob("createTableJobHandler")
    public void createTableJobHandler() throws Exception {
        String date = LocalDate.now().plusDays(1)
        .format(DateTimeFormatter.ofPattern("yyyyMMdd"));// 明天
        XxlJobHelper.log("## 开始初始化明日增量数据表,日期：{}...", date);
        // 分片序号
        int hashKey = 0;
        //表名后缀
        String tableNameSuffix = TableConstants.buildTableNameSuffix(date, hashKey);
        // 创建表
        createTableMapper.createDataAlignFollowingCountTempTable(tableNameSuffix);
        XxlJobHelper.log("## 创建表成功,日期：{}", date);
    }
}
