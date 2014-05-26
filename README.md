activiti-next-taskDef-handle
============================

#activiti5 获取后续流转节点列表

# NextTaskTest.java

## 测试

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
