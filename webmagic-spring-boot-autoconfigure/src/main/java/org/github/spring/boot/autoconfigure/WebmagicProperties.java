package org.github.spring.boot.autoconfigure;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.Scheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gh on 2017/4/26.
 */

@ConfigurationProperties(prefix = "webmagic")
public class WebmagicProperties {

    private Map<String, ? extends Pipeline> pipelines = new HashMap<>();





}
