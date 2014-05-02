package com.myfeike.activiti;

import org.activiti.engine.impl.task.TaskDefinition;

/** 
 * @author  izerui.com
 */
public class NextTaskException extends RuntimeException{
	
	private TaskDefinition taskDefinition;
	
	public NextTaskException(String message) {
		super(message);
	}
	
	public NextTaskException(String message,TaskDefinition taskDefinition){
		super(message);
		this.taskDefinition = taskDefinition;
	}

	public TaskDefinition getTaskDefinition() {
		return taskDefinition;
	}

	public void setTaskDefinition(TaskDefinition taskDefinition) {
		this.taskDefinition = taskDefinition;
	}
	
	
	

}
