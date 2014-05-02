package com.myfeike.activiti;

import org.activiti.engine.TaskService;
import org.activiti.engine.impl.task.TaskDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/** 
 * @author  izerui.com
 */
@Service
public class TaskOperateService implements ITaskOperateService,NextTaskConstans{


    @Autowired
    TaskService taskService;

	@Override
	public TaskDefinition getNextTaskDefinition(String taskId) {
		Map<String,Object> variables = new HashMap<String,Object>();
		variables.put(NEXT_TASK_PROCESS_VARIABLE_NAME, true);
		try{
            taskService.complete(taskId,variables);
		}catch(NextTaskException e){
			return e.getTaskDefinition();
		}
		return null;
	}

}
