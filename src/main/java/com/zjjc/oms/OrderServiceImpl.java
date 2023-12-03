package com.zjjc.oms;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: oms
 * Created by tangli on 2023/12/3 17:21
 */
@Service
public class OrderServiceImpl implements OrderServiceI {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private RepositoryService repositoryService;

    @Override
    public boolean startTask(String key) {
        ProcessInstance test01 = runtimeService.startProcessInstanceByKey(key);
        String id = test01.getId();
        System.out.println("流程id=" + id);
        return true;
    }

    @Override
    public List getTaskList() {
        return historyService.createHistoricActivityInstanceQuery().list();
    }

    @Override
    public boolean complete(String taskId) {
        taskService.complete(taskId);
        return true;
    }

    @Override
    public boolean deleteProcessInstance(String runId) {
        runtimeService.deleteProcessInstance(runId, "结束");
        return true;
    }
}