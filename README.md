activiti-next-taskDef-handle
============================

#activiti5 获取下个即将流转到得 Usertask 节点信息

# NextTaskTest.java

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

###注意

- 1. 流程设计不能有异步节点.或者异步监听
- 2. 获取下一步当前线程. 不能跟 正常的 complete等操作在一个线程中. 因为是用的异常机制抛出下一步节点信息的. 所以业务会回滚
