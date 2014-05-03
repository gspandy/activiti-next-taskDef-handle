import com.myfeike.proxy.service.ActivitiServiceProxy;
import com.myfeike.activiti.TaskOperateService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.task.TaskDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

/**
 * @author  izerui.com
 */
public class NextTaskTest extends AbstractBaseTest {

    RuntimeService runtimeService;

    TaskService taskService;

    @Autowired
    TaskOperateService taskOperateService;

    RepositoryService repositoryService;

    @Before
    public void init(){
        runtimeService = ((ActivitiServiceProxy)taskOperateService).getRuntimeService();
        taskService = ((ActivitiServiceProxy)taskOperateService).getTaskService();
        repositoryService = ((ActivitiServiceProxy)taskOperateService).getRepositoryService();

        repositoryService.createDeployment().addClasspathResource("diagrams/NextTask.bpmn").name("nextTask").deploy();

    }


    @After
    public void showTasks(){
        taskService.createTaskQuery().list();
        Long num = taskService.createTaskQuery().count();
        log.info("共有 {} 条流程",num);
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
            }else{
                log.info("      下个节点是: 结束节点?");
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
