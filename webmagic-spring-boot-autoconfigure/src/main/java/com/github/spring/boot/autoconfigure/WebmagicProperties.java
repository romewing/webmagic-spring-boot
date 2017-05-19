package com.github.spring.boot.autoconfigure;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.Scheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Configuration properties for WebMagic
 *
 * @author ZHANG Yi
 */

@ConfigurationProperties(prefix = "webmagic")
public class WebmagicProperties {


    private String url;

    private String cron;

    private int fixedRate;

    private int fixedDelay;

    private Class<? extends PageProcessor> pageProcessor;

    private List<Class<? extends Pipeline>> pipeLines;


    private Class<? extends Scheduler> scheduler;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCron() {
        return cron;
    }

    public int getFixedRate() {
        return fixedRate;
    }

    public void setFixedRate(int fixedRate) {
        this.fixedRate = fixedRate;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }


    public Class<? extends PageProcessor> getPageProcessor() {
        return pageProcessor;
    }

    public List<Class<? extends Pipeline>> getPipeLines() {
        return pipeLines;
    }

    public void setPipeLines(List<Class<? extends Pipeline>> pipeLines) {
        this.pipeLines = pipeLines;
    }

    public Class<? extends Scheduler> getScheduler() {
        return scheduler;
    }

    public void setScheduler(Class<? extends Scheduler> scheduler) {
        this.scheduler = scheduler;
    }

    public void setPageProcessor(Class<? extends PageProcessor> pageProcessor) {
        this.pageProcessor = pageProcessor;
    }

    public int getFixedDelay() {
        return fixedDelay;
    }

    public void setFixedDelay(int fixedDelay) {
        this.fixedDelay = fixedDelay;
    }
}
