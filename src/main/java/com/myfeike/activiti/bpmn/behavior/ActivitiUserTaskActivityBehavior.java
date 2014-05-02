package com.myfeike.activiti.bpmn.behavior;

import com.myfeike.activiti.NextTaskConstans;
import com.myfeike.activiti.NextTaskException;

import org.activiti.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;
import org.activiti.engine.impl.task.TaskDefinition;

/**
 * Created by izerui.com on 14-3-27.
 */
public class ActivitiUserTaskActivityBehavior extends UserTaskActivityBehavior implements NextTaskConstans {
	
	public ActivitiUserTaskActivityBehavior(TaskDefinition taskDefinition) {
        super(taskDefinition);
    }

	public void execute(ActivityExecution execution) throws Exception {
		
		if(execution.hasVariable(NEXT_TASK_PROCESS_VARIABLE_NAME)){
			execution.removeVariable(NEXT_TASK_PROCESS_VARIABLE_NAME);
			throw new NextTaskException(NEXT_TASK_EXCEPTION_TEXT, taskDefinition);
		}
		
        super.execute(execution);
    }

}
