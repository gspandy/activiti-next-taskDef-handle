package com.myfeike;

import org.activiti.engine.impl.pvm.process.ActivityImpl;

import java.util.Stack;

/**
 * Created by serv on 14-5-25.
 */
public class NextActivitysContext {

    protected static ThreadLocal<Stack<ActivityImpl>> stackThreadLocal = new ThreadLocal<Stack<ActivityImpl>>();


    public static void addActivity(ActivityImpl activity) {
        Stack<ActivityImpl> stack = getActivitys();
        stack.push(activity);
        stackThreadLocal.set(stack);
    }

    public static Stack<ActivityImpl> getActivitys(){
        Stack<ActivityImpl> stack = stackThreadLocal.get();
        if(stack==null){
            stack = new Stack<ActivityImpl>();
        }
        return stack;
    }
}
