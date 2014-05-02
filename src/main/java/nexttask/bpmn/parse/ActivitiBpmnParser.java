package nexttask.bpmn.parse;

import org.activiti.engine.impl.bpmn.parser.BpmnParser;
import org.activiti.engine.impl.bpmn.parser.factory.AbstractBehaviorFactory;
import org.activiti.engine.impl.bpmn.parser.factory.ActivityBehaviorFactory;
/**
 * Created by izerui.com on 14-3-27.
 */
public class ActivitiBpmnParser extends BpmnParser{

	public void setActivityBehaviorFactory(ActivityBehaviorFactory activityBehaviorFactory) {
		((AbstractBehaviorFactory)activityBehaviorFactory).setExpressionManager(expressionManager);
		super.setActivityBehaviorFactory(activityBehaviorFactory);
	}
	
}
