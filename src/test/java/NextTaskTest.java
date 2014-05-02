import com.myfeike.activiti.ITaskOperateService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.task.TaskDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

/**
 * Created by izerui.com on 14-5-2.
 */
@Transactional
public class NextTaskTest extends AbstractBaseTest {

    @Autowired
    RuntimeService runtimeService;

    @Autowired
    TaskService taskService;

    @Autowired
    ITaskOperateService taskOperateService;

    @Autowired
    RepositoryService repositoryService;

    @Before
    public void init(){

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
        log.info("id " + processInstance.getId() + " "
                + processInstance.getProcessDefinitionId());

        log.info("共有 " + taskService.createTaskQuery().count() + " 条流程");

    }
    /**
     * 获取任务的下一个用户节点信息
     */
    @Test
    public void nextTasks(){
        List<Task> tasks = getTasks();
        for (Task task : tasks) {
            TaskDefinition taskDefinition = taskOperateService.getNextTaskDefinition(task.getId());
            log.info("任务:" + task.getId());
            log.info("      当前节点是:" + task.getTaskDefinitionKey());

            if(taskDefinition!=null){

                log.info("      下个节点是:" + taskDefinition.getKey());
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
            taskService.complete(task.getId());

        }
    }


    private List<Task> getTasks(){
        return taskService.createTaskQuery().list();
    }


}