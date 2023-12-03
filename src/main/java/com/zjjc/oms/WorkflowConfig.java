package com.zjjc.oms;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Description: oms
 * Created by tangli on 2023/12/3 16:49
 */
@Configuration
public class WorkflowConfig {

    @Autowired
    RepositoryService repositoryService;

    @PostConstruct
    public void init(){
        System.out.println("WorkflowConfig init");
        //进行部署
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("bpmn/order-process.bpmn20.xml")
                .name("订单流程")
                .deploy();
        //输出部署的一些信息
        System.out.println("流程部署ID:"+deployment.getId());
        System.out.println("流程部署名称:"+deployment.getName());
    }
}