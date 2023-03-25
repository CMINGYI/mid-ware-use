package com.chengming.config;

import com.alibaba.csp.sentinel.adapter.gateway.common.SentinelGatewayConstants;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiDefinition;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiPathPredicateItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiPredicateItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.GatewayApiDefinitionManager;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayParamFlowItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import com.alibaba.csp.sentinel.adapter.gateway.sc.SentinelGatewayFilter;
import com.alibaba.csp.sentinel.adapter.gateway.sc.exception.SentinelGatewayBlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Name: GatewayConfig
 * @Author: kitchening
 * @Date: 2023-03-25 16:34
 * @Description: GatewayConfig
 * @Version: V1.0
 */
@Configuration
public class GatewayConfig {

    private final List<ViewResolver> viewResolvers;

    private final ServerCodecConfigurer serverCodecConfigurer;
    @Value("${gateway.consumer:interface}")
    private String consumer = "interface";
    @Value("${gateway.provider:service}")
    private String provider = "service";

    public GatewayConfig(ObjectProvider<List<ViewResolver>> viewResolversProvider, ServerCodecConfigurer serverCodecConfigurer) {
        this.viewResolvers = viewResolversProvider.getIfAvailable(Collections::emptyList);
        this.serverCodecConfigurer = serverCodecConfigurer;
    }


    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SentinelGatewayBlockExceptionHandler sentinelGatewayBlockExceptionHandler() {
        return new SentinelGatewayBlockExceptionHandler(viewResolvers, serverCodecConfigurer);
    }

    @Bean
    @Order(-1)
    public GlobalFilter sentinelGateWayFilter() {
        return new SentinelGatewayFilter();
    }

    @PostConstruct
    public void doInit() {
        initCustomizedApis();
        initGateWayRules();
    }


    public void initCustomizedApis() {
        Set<ApiDefinition> definitions = Sets.newConcurrentHashSet();
        HashSet<ApiPredicateItem> consumerPredicateItems = new HashSet<>();
        consumerPredicateItems.add(new ApiPathPredicateItem().setPattern("/interface/**").setMatchStrategy(SentinelGatewayConstants.URL_MATCH_STRATEGY_PREFIX));
        ApiDefinition consumerApiDefinition = new ApiDefinition(consumer).setPredicateItems(consumerPredicateItems);
        HashSet<ApiPredicateItem> providerPredicateItems = new HashSet<>();
        providerPredicateItems.add(new ApiPathPredicateItem().setPattern("/service/**")
                .setMatchStrategy(SentinelGatewayConstants.URL_MATCH_STRATEGY_PREFIX));
        ApiDefinition providerApiDefinition = new ApiDefinition(provider).setPredicateItems(providerPredicateItems);
        definitions.add(consumerApiDefinition);
        definitions.add(providerApiDefinition);
        GatewayApiDefinitionManager.loadApiDefinitions(definitions);
    }


    private void initGateWayRules() {
        Set<GatewayFlowRule> flowRules = Sets.newConcurrentHashSet();
        flowRules.add(
                new GatewayFlowRule(consumer).setCount(10)
                        .setIntervalSec(1)
        );
        flowRules.add(
                new GatewayFlowRule(consumer).setCount(2)
                        .setBurst(2)
                        .setIntervalSec(2)
                        .setParamItem(
                                new GatewayParamFlowItem()
                                        .setParseStrategy(SentinelGatewayConstants.PARAM_PARSE_STRATEGY_HEADER)
                                        .setFieldName("X-Sentinel-Flag")
                        )
        );
        flowRules.add(new GatewayFlowRule(provider)
                .setCount(10)
                .setIntervalSec(1)
                .setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_RATE_LIMITER)
                .setMaxQueueingTimeoutMs(600)
                .setParamItem(
                        new GatewayParamFlowItem()
                                .setParseStrategy(SentinelGatewayConstants.PARAM_PARSE_STRATEGY_HEADER)
                                .setFieldName("X-Sentinel-Flag")
                )
        );
        flowRules.add(new GatewayFlowRule(provider)
                .setCount(1)
                .setIntervalSec(1)
                .setParamItem(
                        new GatewayParamFlowItem()
                                .setParseStrategy(SentinelGatewayConstants.PARAM_PARSE_STRATEGY_URL_PARAM)
                                .setFieldName("pa")
                )
        );
        flowRules.add(new GatewayFlowRule(provider)
                .setCount(2)
                .setIntervalSec(30)
                .setParamItem(
                        new GatewayParamFlowItem()
                                .setParseStrategy(SentinelGatewayConstants.PARAM_PARSE_STRATEGY_URL_PARAM)
                                .setFieldName("type")
                                .setPattern("warn")
                                .setMatchStrategy(SentinelGatewayConstants.PARAM_MATCH_STRATEGY_CONTAINS)
                )
        );

        flowRules.add(new GatewayFlowRule(provider)
                .setResourceMode(SentinelGatewayConstants.RESOURCE_MODE_CUSTOM_API_NAME)
                .setCount(5)
                .setIntervalSec(1)
                .setParamItem(
                        new GatewayParamFlowItem()
                                .setParseStrategy(SentinelGatewayConstants.PARAM_PARSE_STRATEGY_URL_PARAM)
                                .setFieldName("pn")
                )
        );
        GatewayRuleManager.loadRules(flowRules);
    }
}
