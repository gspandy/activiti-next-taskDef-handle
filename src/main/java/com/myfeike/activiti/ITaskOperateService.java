package com.myfeike.activiti;

import org.activiti.engine.impl.task.TaskDefinition;

/** 
 * @author  izerui.com
 * @version createtime：2014年5月2日 下午3:11:28 
 */
public interface ITaskOperateService {
	
	/**
	 * 根据流程实例ID获取当前任务后面即将流转到的节点信息
	 * @param taskId 任务ID
	 * @return TaskDefinition
	 */
	public TaskDefinition getNextTaskDefinition(String taskId);

}
