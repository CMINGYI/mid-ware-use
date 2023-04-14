package com.chengming.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Name: MeterConfig
 * @Author: kitchening
 * @Date: 2023-03-27 21:40
 * @Description: MeterConfig
 * @Version: V1.0
 */
@Configuration
public class MeterConfig {

    public MeterRegistryCustomizer<MeterRegistry> meterConfig(@Value("${spring.application.name}") String applicationName) {
        return registry -> registry.config().commonTags("application", applicationName);
    }
}
