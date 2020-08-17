package web.config;

import org.quartz.SimpleTrigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import web.planner.CronQuartzTask;
import web.planner.QuartzTask;

//@Configuration
//public class QuartzConfig {
//
//    @Bean(name = "simpleTrigger")
//    public SimpleTriggerFactoryBean getSimpleTriggerFactoryBean() {
//        SimpleTriggerFactoryBean stfb = new SimpleTriggerFactoryBean();
//        stfb.setJobDetail(getSimpleQuartzJob().getObject());
//        stfb.setStartDelay(1000);
//        return stfb;
//    }
//    @Bean(name = "simpleQuartzJob")
//    public MethodInvokingJobDetailFactoryBean getSimpleQuartzJob() {
//        MethodInvokingJobDetailFactoryBean factoryBean = new MethodInvokingJobDetailFactoryBean();
//        factoryBean.setTargetBeanName("simpleQuartzTask");
//        factoryBean.setTargetMethod("simpleTaskMethod");
//        return factoryBean;
//    }
//    @Bean(name = "simpleQuartzTask")
//    public QuartzTask getSimpleQuartzTask() {
//        return new QuartzTask();
//    }
//
//
//    @Bean(name = "cronTrigger")
//    public CronTriggerFactoryBean getCronTriggerFactoryBean() {
//        CronTriggerFactoryBean ctfb = new CronTriggerFactoryBean();
//
//        ctfb.setJobDetail(getQuartzCronJob().getObject());
//
//        ctfb.setCronExpression("10 * * * * ?");
//        return ctfb;
//    }
//    @Bean(name = "quartzCronJob")
//    public MethodInvokingJobDetailFactoryBean getQuartzCronJob() {
//        MethodInvokingJobDetailFactoryBean factoryBean = new MethodInvokingJobDetailFactoryBean();
//        factoryBean.setTargetBeanName("cronQuartzTask");
//        factoryBean.setTargetMethod("cronTaskMethod");
//        return factoryBean;
//    }
//    @Bean(name = "cronQuartzTask")
//    public CronQuartzTask getCronQuartzTask() {
//        return new CronQuartzTask();
//    }
//
//
//    @Bean(name = "schedulerFactoryBean")
//    public SchedulerFactoryBean getSchedulerFactoryBean() {
//        SchedulerFactoryBean scheduler  = new SchedulerFactoryBean();
//        scheduler.setTriggers(getSimpleTriggerFactoryBean().getObject(), getCronTriggerFactoryBean().getObject());
//        return scheduler ;
//    }
//
//}
