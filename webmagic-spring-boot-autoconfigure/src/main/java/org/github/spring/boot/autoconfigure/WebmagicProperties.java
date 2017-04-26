package org.github.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.Scheduler;

import java.util.List;

/**
 * Created by gh on 2017/4/26.
 */

@ConfigurationProperties(prefix = "webmagic")
public class WebmagicProperties {

    private String[] urls;

    private boolean start;

    private String uuid;

    private int threadNum;

    private Class<? extends PageProcessor> pageProcessor;

    private List<Class<? extends Pipeline>> pipelines;

    private Class<? extends Scheduler> scheduler;


    public Class<? extends PageProcessor> getPageProcessor() {
        return pageProcessor;
    }

    public Class<? extends Scheduler> getScheduler() {
        return scheduler;
    }


    public List<Class<? extends Pipeline>> getPipelines() {
        return pipelines;
    }

    public String[] getUrls() {
        return urls;
    }

    public String getUuid() {
        return uuid;
    }

    public int getThreadNum() {
        return threadNum;
    }

    public boolean isStart() {
        return start;
    }

    public void setUrls(String[] urls) {
        this.urls = urls;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setThreadNum(int threadNum) {
        this.threadNum = threadNum;
    }

    public void setPageProcessor(Class<? extends PageProcessor> pageProcessor) {
        this.pageProcessor = pageProcessor;
    }

    public void setPipelines(List<Class<? extends Pipeline>> pipelines) {
        this.pipelines = pipelines;
    }

    public void setScheduler(Class<? extends Scheduler> scheduler) {
        this.scheduler = scheduler;
    }
}
