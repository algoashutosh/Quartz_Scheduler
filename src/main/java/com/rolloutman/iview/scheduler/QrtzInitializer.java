package com.rolloutman.iview.scheduler;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QrtzInitializer {
	public static void initialiseScheduling() throws SchedulerException
	{
		JobDetail job=JobBuilder.newJob(QrtzJob.class).build();
		//Trigger t1=TriggerBuilder.newTrigger().withIdentity("CronTrigger").withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *")).build();
		Trigger t1=TriggerBuilder.newTrigger().withIdentity("CronTrigger").withSchedule(CronScheduleBuilder.cronSchedule("0 0 15 1/1 * ? *")).build();
		Scheduler sc=StdSchedulerFactory.getDefaultScheduler();
		sc.start();
		sc.scheduleJob(job,t1);
	}
}
