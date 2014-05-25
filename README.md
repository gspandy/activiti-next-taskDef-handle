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
msg:id 5 nextTask:1:4	thread:main	level:INFO 	logger:AbstractBaseTest
msg:任务:10	thread:main	level:INFO 	logger:AbstractBaseTest
msg:      当前节点是:usertask1	thread:main	level:INFO 	logger:AbstractBaseTest
msg:      下个节点是:usertask2	thread:main	level:INFO 	logger:AbstractBaseTest
msg:任务:15	thread:main	level:INFO 	logger:AbstractBaseTest
msg:      当前节点是:usertask2	thread:main	level:INFO 	logger:AbstractBaseTest
msg:      下个节点是:parallelgateway1	thread:main	level:INFO 	logger:AbstractBaseTest
msg:      下个节点是:usertask3	thread:main	level:INFO 	logger:AbstractBaseTest
msg:      下个节点是:usertask4	thread:main	level:INFO 	logger:AbstractBaseTest
msg:任务:28	thread:main	level:INFO 	logger:AbstractBaseTest
msg:      当前节点是:usertask3	thread:main	level:INFO 	logger:AbstractBaseTest
msg:      下个节点是:parallelgateway2	thread:main	level:INFO 	logger:AbstractBaseTest
msg:任务:31	thread:main	level:INFO 	logger:AbstractBaseTest
msg:      当前节点是:usertask4	thread:main	level:INFO 	logger:AbstractBaseTest
msg:      下个节点是:usertask5	thread:main	level:INFO 	logger:AbstractBaseTest
msg:任务:37	thread:main	level:INFO 	logger:AbstractBaseTest
msg:      当前节点是:usertask5	thread:main	level:INFO 	logger:AbstractBaseTest
msg:      下个节点是:parallelgateway2	thread:main	level:INFO 	logger:AbstractBaseTest
msg:      下个节点是:usertask6	thread:main	level:INFO 	logger:AbstractBaseTest
msg:任务:43	thread:main	level:INFO 	logger:AbstractBaseTest
msg:      当前节点是:usertask6	thread:main	level:INFO 	logger:AbstractBaseTest
msg:      下个节点是:subprocess1	thread:main	level:INFO 	logger:AbstractBaseTest
msg:      下个节点是:startevent2	thread:main	level:INFO 	logger:AbstractBaseTest
msg:      下个节点是:usertask7	thread:main	level:INFO 	logger:AbstractBaseTest
msg:任务:51	thread:main	level:INFO 	logger:AbstractBaseTest
msg:      当前节点是:usertask7	thread:main	level:INFO 	logger:AbstractBaseTest
msg:      下个节点是:endevent1	thread:main	level:INFO 	logger:AbstractBaseTest
msg:      下个节点是:endevent2	thread:main	level:INFO 	logger:AbstractBaseTest
msg:共有 0 个任务	thread:main	level:INFO 	logger:AbstractBaseTest
```

###注意

- 1. 流程设计不能有异步节点.或者异步监听
- 2. 获取下一步当前线程. 不能跟 正常的 complete等操作在一个线程中. 因为是用的异常机制抛出下一步节点信息的. 所以业务会回滚
