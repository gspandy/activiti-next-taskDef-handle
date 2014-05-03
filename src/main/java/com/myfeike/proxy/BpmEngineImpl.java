package com.myfeike.proxy;

import com.myfeike.activiti.TaskOperateService;
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
