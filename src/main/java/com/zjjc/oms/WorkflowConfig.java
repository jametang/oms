package com.zjjc.oms;

import jakarta.annotation.PostConstruct;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
public class WorkflowConfig {


    @PostConstruct
    public void init(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.createDeployment().addClasspathResource("bpmn/order-process.bpmn20.xml");
    }

/*    @Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration(DataSource dataSource) {
        SpringProcessEngineConfiguration configuration = new SpringProcessEngineConfiguration();
        configuration.setDataSource(dataSource);
        // 配置其他属性
        return configuration;
    }

    @Bean
    public ProcessEngineFactoryBean processEngine(SpringProcessEngineConfiguration springProcessEngineConfiguration) {
        ProcessEngineFactoryBean factoryBean = new ProcessEngineFactoryBean();
        factoryBean.setProcessEngineConfiguration(springProcessEngineConfiguration);
        return factoryBean;
    }

    @Bean
    public RepositoryService repositoryService(ProcessEngineFactoryBean processEngineFactoryBean) throws Exception {
        return Objects.requireNonNull(processEngineFactoryBean.getObject()).getRepositoryService();
    }*/

}
