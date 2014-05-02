package com.myfeike.activiti.bpmn.parse;

import com.myfeike.activiti.bpmn.behavior.ActivitiUserTaskActivityBehavior;

import org.activiti.bpmn.model.UserTask;
import org.activiti.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.activiti.engine.impl.bpmn.parser.factory.DefaultActivityBehaviorFactory;
import org.activiti.engine.impl.task.TaskDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Created by izerui.com on 14-3-27.
 */
public class ActivityBehaviorFactory extends DefaultActivityBehaviorFactory {
	private static Logger log = LoggerFactory.getLogger(ActivityBehaviorFactory.class);

	//test
	public UserTaskActivityBehavior createUserTaskActivityBehavior(UserTask userTask, TaskDefinition taskDefinition) {
		log.info("change usertask Behavior : {}", userTask);
		return new ActivitiUserTaskActivityBehavior(taskDefinition);
	}

}
