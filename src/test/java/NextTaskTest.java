import com.myfeike.activiti.proxy.ActivitiServiceProxy;
import com.myfeike.service.TaskOperateService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
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

        startProcess();
    }

    public void startProcess() {

        Map<String, Object> variableMap = new HashMap<String, Object>();
        variableMap.put("name", "Activiti");
        variableMap.put("num", 0);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("nextTask", variableMap);
        assertNotNull(processInstance.getId());
        log.info("id " + processInstance.getId() + " "
                + processInstance.getProcessDefinitionId());


    }


    @After
    public void showTasks(){
        Long num = taskService.createTaskQuery().count();
        log.info("共有 {} 个任务",num);
    }

    /**
     * 获取任务的下一个用户节点信息
     */
    @Test
    public void nextTasks(){
        List<Task> tasks = getTasks();
        if(tasks==null||tasks.size()==0){
            return;
        }
        for (Task task : tasks) {
            List<ActivityImpl> activitys = taskOperateService.getNextActivitys(task.getId());
            log.info("任务:" + task.getId());
            log.info("      当前节点是:" + task.getTaskDefinitionKey());

            if(activitys!=null){

                for(ActivityImpl activity:activitys){
                    log.info("      下个节点是:" + activity.getId());
                }

            }

            taskService.complete(task.getId());

        }
        nextTasks();
    }


    private List<Task> getTasks(){
        return taskService.createTaskQuery().list();
    }


}
