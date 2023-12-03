package com.zjjc.oms;

import java.util.List;

/**
 * Description: oms
 * Created by tangli on 2023/12/3 17:20
 */
public interface OrderServiceI {

    /**
     * 根据流程key开启一个流程
     * @param key
     * @return
     */
    boolean startTask(String key);

    /**
     * 查询待办
     * @return
     */
    List getTaskList();

    /**
     * 根据任务id提交任务
     * @param taskId
     * @return
     */
    boolean complete(String taskId);

    /**
     * 根据流程id直接结束流程
     * @param runId
     * @return
     */
    boolean deleteProcessInstance(String runId);
}
