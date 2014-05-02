activiti-next-taskDef-handle
============================

#activiti5 获取下个即将流转到得 Usertask 节点信息

# ProcessTestNextTask.java

## 测试

- startProcess 启动几条流程
- nextTasks 运行查看任务的流转信息
- completeTasks 完成所有任务 , 之后继续运行 nextTasks 以查看 更新的 任务流转信息

## 运行如下:

```java
任务:11206
      当前节点是:usertask5
任务:11209
      当前节点是:usertask4
      下个节点是:usertask5
任务:11212
      当前节点是:usertask4
      下个节点是:usertask5
任务:11215
      当前节点是:usertask4
      下个节点是:usertask5
```