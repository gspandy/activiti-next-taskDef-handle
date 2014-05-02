package nexttask;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.task.TaskDefinition;

/** 
 * @author  izerui.com
 * @version createtime：2014年5月2日 下午3:13:29 
 */
public class TaskOperateServiceImpl implements TaskOperateService,NextTaskConstans{

	@Override
	public TaskDefinition getNextTaskDefinition(String taskId) {
		TaskService service  = ProcessEngines.getDefaultProcessEngine().getTaskService();
		Map<String,Object> variables = new HashMap<String,Object>();
		variables.put(NEXT_TASK_PROCESS_VARIABLE_NAME, true);
		try{
			service.complete(taskId,variables);
		}catch(NextTaskException e){
			return e.getTaskDefinition();
		}
		return null;
	}

}
