package com.mleitejunior.schedulertimertask;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzApp {
    /**
     * @param args
     */
    public static void main(String[] args) {
        SchedulerFactory shedFact = new StdSchedulerFactory();
        try {
            Scheduler scheduler = shedFact.getScheduler();
            scheduler.start();
            JobDetail job = JobBuilder.newJob(ValidadorJob.class)
                    .withIdentity("validadorJOB", "grupo01")
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("validadorTRIGGER","grupo01")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?"))
                    .build();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
