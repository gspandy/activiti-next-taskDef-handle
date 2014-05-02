package nexttask;

import org.activiti.engine.impl.task.TaskDefinition;

/** 
 * @author  izerui.com
 * @version createtime：2014年5月2日 下午2:56:35 
 */
public class NextTaskException extends RuntimeException{
	
	private TaskDefinition taskDefinition;
	
	public NextTaskException() {
		// TODO Auto-generated constructor stub
		super();
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
