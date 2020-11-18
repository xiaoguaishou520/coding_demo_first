package com.tencent.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.studb2.datasource")
public class Studb2Datasource extends BaseDatasource{
}
