package com.myfeike.activiti.listener;

import com.myfeike.NextActivitysContext;
import org.activiti.engine.delegate.event.ActivitiActivityEvent;
import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;

/**
 * Created by serv on 14-5-25.
 */
public class ActivityEventListener implements ActivitiEventListener {

    @Override
    public void onEvent(ActivitiEvent ev) {

        ActivitiActivityEvent event = (ActivitiActivityEvent) ev;

        ProcessDefinitionImpl processDefinition = (ProcessDefinitionImpl) event.getEngineServices().getRepositoryService().getProcessDefinition(event.getProcessDefinitionId());
        ActivityImpl activity = processDefinition.findActivity(event.getActivityId());
        NextActivitysContext.addActivity(activity);

    }

    @Override
    public boolean isFailOnException() {
        return true;
    }
}
