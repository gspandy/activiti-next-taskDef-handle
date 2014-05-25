package com.myfeike.activiti.proxy;

import com.myfeike.service.TaskOperateService;
import org.activiti.engine.impl.ProcessEngineImpl;

/**
 * Created by izerui.com on 14-5-3.
 */
public class BpmEngineImpl extends ProcessEngineImpl implements BpmEngine{

    protected TaskOperateService taskOperateService;

    public BpmEngineImpl(BpmEngineConfiguration processEngineConfiguration) {
        super(processEngineConfiguration);
        taskOperateService = processEngineConfiguration.getTaskOperateService();
    }

    @Override
    public TaskOperateService getTaskOperateService() {
        return taskOperateService;
    }
}
