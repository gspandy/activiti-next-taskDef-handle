package com.myfeike.proxy;

import com.myfeike.activiti.TaskOperateService;
import com.myfeike.activiti.TaskOperateServiceImpl;
import org.activiti.spring.SpringProcessEngineConfiguration;

/**
 * 工作流配置
 * Created by izerui.com on 14-5-3.
 */
public class BpmEngineConfiguration extends SpringProcessEngineConfiguration{

    protected TaskOperateService taskOperateService = new TaskOperateServiceImpl();


    @Override
    protected void initServices() {
        super.initServices();
        initService(taskOperateService);
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
