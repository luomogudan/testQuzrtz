package com.example.myquartz.config;

import com.example.myquartz.controller.QuartzController;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail testQuartzDetail(){
        return JobBuilder.newJob(QuartzController.class).withIdentity("quartzController").storeDurably().build();
    }

    @Bean
      public Trigger testQuartzTrigger(){
                 SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                         .withIntervalInSeconds(10)  //设置时间周期单位秒
                         .repeatForever();
                 return TriggerBuilder.newTrigger().forJob(testQuartzDetail())
                         .withIdentity("quartzController").withSchedule(scheduleBuilder)
                         .build();
             }
}
