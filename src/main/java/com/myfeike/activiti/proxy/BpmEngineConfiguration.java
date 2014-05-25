package com.myfeike.activiti.proxy;

import com.myfeike.service.TaskOperateService;
import com.myfeike.service.TaskOperateServiceImpl;
import org.activiti.spring.SpringProcessEngineConfiguration;

/**
 * 工作流配置
 * Created by izerui.com on 14-5-3.
 */
public class BpmEngineConfiguration extends SpringProcessEngineConfiguration{

    protected TaskOperateService taskOperateService = new TaskOperateServiceImpl();


    public BpmEngineConfiguration() {
        super();
        setActivityFontName("微软雅黑");
        setLabelFontName("微软雅黑");
        setDatabaseSchemaUpdate("true");
    }

    @Override
    protected void initServices() {
        super.initServices();
        initService(taskOperateService);
        proxyServices(taskOperateService);
    }

    public void proxyServices(Object service){
        if (service instanceof ActivitiServiceProxy) {
            ((ActivitiServiceProxy)service).setRepositoryService(repositoryService);
            ((ActivitiServiceProxy)service).setTaskService(taskService);
            ((ActivitiServiceProxy)service).setRuntimeService(runtimeService);
            ((ActivitiServiceProxy)service).setFormService(formService);
            ((ActivitiServiceProxy)service).setHistoryService(historyService);
            ((ActivitiServiceProxy)service).setIdentityService(identityService);
            ((ActivitiServiceProxy)service).setManagementService(managementService);
            ((ActivitiServiceProxy)service).setTransactionManager(transactionManager);
        }
    }

    @Override
    public BpmEngine buildProcessEngine() {
        init();
        return new BpmEngineImpl(this);
    }

    public TaskOperateService getTaskOperateService() {
        return taskOperateService;
    }

    public void setTaskOperateService(TaskOperateService taskOperateService) {
        this.taskOperateService = taskOperateService;
    }
}
