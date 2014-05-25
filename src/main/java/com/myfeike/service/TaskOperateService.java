package com.myfeike.service;

import org.activiti.engine.impl.pvm.process.ActivityImpl;

import java.util.List;

/** 
 * @author  izerui.com
 * @version createtime：2014年5月2日 下午3:11:28 
 */
public interface TaskOperateService {
	
	/**
	 * 根据流程实例ID获取当前任务后面即将流转到的节点信息
	 * @param taskId 任务ID
	 * @return NextActivitys
	 */
	public List<ActivityImpl> getNextActivitys(String taskId);

}
