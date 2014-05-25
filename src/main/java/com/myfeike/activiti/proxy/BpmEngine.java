package com.myfeike.activiti.proxy;

import com.myfeike.service.TaskOperateService;
import org.activiti.engine.ProcessEngine;

/**
 * 提供所有工作流服务
 * Created by izerui.com on 14-5-3.
 */
public interface BpmEngine extends ProcessEngine {

    TaskOperateService getTaskOperateService();

}
