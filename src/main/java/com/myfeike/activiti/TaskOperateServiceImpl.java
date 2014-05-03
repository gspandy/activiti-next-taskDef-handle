package com.myfeike.activiti;

import org.activiti.engine.impl.task.TaskDefinition;

import java.util.HashMap;
import java.util.Map;

/** 
 * @author  izerui.com
 */
public class TaskOperateServiceImpl extends ActivitiServiceProxy implements TaskOperateService,NextTaskConstans{


	@Override
	public TaskDefinition getNextTaskDefinition(String taskId) {
		Map<String,Object> variables = new HashMap<String,Object>();
		variables.put(NEXT_TASK_PROCESS_VARIABLE_NAME, true);
		try{
            taskService.complete(taskId, variables);
		}catch(NextTaskException e){
			return e.getTaskDefinition();
		}
		return null;
	}

}
