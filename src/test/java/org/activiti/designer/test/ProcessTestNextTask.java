package org.activiti.designer.test;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nexttask.TaskOperateService;
import nexttask.TaskOperateServiceImpl;

import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.task.TaskDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Before;
import org.junit.Test;

public class ProcessTestNextTask {


	private RuntimeService runtimeService;
	private TaskService taskService;
	private RepositoryService repositoryService;
	private TaskOperateService taskOperateService;
	
	@Before
	public void init(){
		runtimeService = ProcessEngines.getDefaultProcessEngine().getRuntimeService();
		taskService = ProcessEngines.getDefaultProcessEngine().getTaskService();
		repositoryService = ProcessEngines.getDefaultProcessEngine().getRepositoryService();
		taskOperateService = new TaskOperateServiceImpl();
		
		repositoryService.createDeployment().addClasspathResource("diagrams/NextTask.bpmn").name("nextTask").deploy();
		
		
	}

	/**
	 * 发起流程
	 * @throws Exception
	 */
	@Test
	public void startProcess() throws Exception {
		
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("name", "Activiti");
		variableMap.put("num", 0);
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("nextTask", variableMap);
		assertNotNull(processInstance.getId());
		System.out.println("id " + processInstance.getId() + " "
				+ processInstance.getProcessDefinitionId());
		
		System.out.println("共有 "+taskService.createTaskQuery().count() + " 条流程");
		
	}
	/**
	 * 获取任务的下一个用户节点信息
	 */
	@Test
	public void nextTasks(){
		List<Task> tasks = getTasks();
		for (Task task : tasks) {
			TaskDefinition taskDefinition = taskOperateService.getNextTaskDefinition(task.getId());
			System.out.println("任务:" + task.getId());
			System.out.println("      当前节点是:"+task.getTaskDefinitionKey());
			
			if(taskDefinition!=null){
				
				System.out.println("      下个节点是:"+taskDefinition.getKey());
			}
			
		}
	}
	
	/**
	 * 完成所有任务
	 */
	@Test
	public void completeTasks(){
		List<Task> tasks = getTasks();
		for (Task task : tasks) {
//			new Thread(new Runnable() {
//				
//				@Override
//				public void run() {
					taskService.complete(task.getId());
					
//				}
//			}).start();
		}
	}
	
	
	private List<Task> getTasks(){
		return taskService.createTaskQuery().list();
	}
	
	private void printSourceAndTargetTaskDefKey(TaskOperateService service){
		while(getTasks()!=null&&getTasks().size()>0){
			
			List<Task> tasks = getTasks();
			for (final Task task : tasks) {
				
				TaskDefinition taskDefinition = service.getNextTaskDefinition(task.getId());
				System.out.println("当前节点是:"+task.getTaskDefinitionKey());
				
				if(taskDefinition!=null){
					
					System.out.println("下个节点是:"+taskDefinition.getKey());
				}
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						taskService.complete(task.getId());
						
					}
				}).start();
				
				System.out.println("完成当前任务!");
				
			}
			
		}
	}
}