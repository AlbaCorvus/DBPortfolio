package com.cjmulcahy.config;

/**
 * Created by Chris on 1/16/2017.
 */
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({ "com.cjmulcahy.**" })
public class SpringRootConfig {
}
