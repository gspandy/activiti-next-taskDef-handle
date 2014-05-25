package com.myfeike.service;

import com.myfeike.NextActivitysContext;
import com.myfeike.activiti.listener.ActivityEventListener;
import com.myfeike.activiti.proxy.ActivitiServiceProxy;
import org.activiti.engine.delegate.event.ActivitiEventType;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Stack;

/**
 * @author  izerui.com
 */
public class TaskOperateServiceImpl extends ActivitiServiceProxy implements TaskOperateService {


    @Override
    public Stack<ActivityImpl> getNextActivitys(final String taskId) {

        new TransactionTemplate(transactionManager).execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                runtimeService.addEventListener(new ActivityEventListener(), ActivitiEventType.ACTIVITY_STARTED);
                taskService.complete(taskId);
                status.setRollbackOnly();
                return null;
            }
        });
        return NextActivitysContext.getActivitys();

    }

}
