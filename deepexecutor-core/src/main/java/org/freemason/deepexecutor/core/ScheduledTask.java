package org.freemason.deepexecutor.core;


public class ScheduledTask {
    private long createTime = System.currentTimeMillis();

    private final long executionTime;

    private final Runnable target;

    ScheduledTask(long executionTime, Runnable target){
        this.executionTime = executionTime;
        this.target = target;
    }

    public long getCreateTime() {
        return createTime;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public Runnable getTarget() {
        return target;
    }

}
