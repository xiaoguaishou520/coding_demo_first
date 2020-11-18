package com.tencent.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.studb1.datasource")
public class Studb1Datasource extends BaseDatasource{


}
