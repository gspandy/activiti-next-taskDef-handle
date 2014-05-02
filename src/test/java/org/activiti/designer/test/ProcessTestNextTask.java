package org.activiti.designer.test;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nexttask.TaskOperateService;
import nexttask.TaskOperateServiceImpl;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.task.TaskDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class ProcessTestNextTask {


	@Rule
	public ActivitiRule activitiRule = new ActivitiRule();
	
	private RuntimeService runtimeService;
	private TaskService taskService;
	
	@Before
	public void init(){
		runtimeService = activitiRule.getRuntimeService();
		taskService = activitiRule.getTaskService();
	}

	
	@Deployment(resources = {"diagrams/NextTask.bpmn",""})
	@Test
	public void startProcess() throws Exception {
		
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("name", "Activiti");
		variableMap.put("num", 0);
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("nextTask", variableMap);
		assertNotNull(processInstance.getId());
		System.out.println("id " + processInstance.getId() + " "
				+ processInstance.getProcessDefinitionId());
		
		TaskOperateService taskOperateService = new TaskOperateServiceImpl();
		
		List<Task> tasks = getTasks();
		
		assertNotNull(tasks);
		
		for (Task task : tasks) {
			TaskDefinition taskDefinition = taskOperateService.getNextTaskDefinition(task.getId());
			System.out.println("当前节点是:"+task.getTaskDefinitionKey());
			System.out.println("下个节点是:"+taskDefinition.getKey());
			
		}
		
		assertNotNull(getTasks());
		
	}
	
	
	private List<Task> getTasks(){
		return taskService.createTaskQuery().taskAssignee("admin").list();
	}
}