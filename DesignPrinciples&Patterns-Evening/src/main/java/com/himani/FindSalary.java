package com.himani;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class FindSalary {
    public static void main(String args[])
    {
        try
        {
            JobDetail job1 = JobBuilder.newJob(Notification.class)
                    .withIdentity("job1", "group1").build();

            Trigger trigger1 = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger1", "group1")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0 12 15 1/1 ? *"))
                    .build();

            Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
            scheduler1.start();
            scheduler1.scheduleJob(job1, trigger1);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
