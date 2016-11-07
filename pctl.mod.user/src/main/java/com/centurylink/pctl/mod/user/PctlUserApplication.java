package com.centurylink.pctl.mod.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.client.RestTemplate;

/**
 * PctlUserApplication class has the main method configured using SpringBootApplication
 * using @ComponentScan for com.centurylink.pctl.mod.user and com.centurylink.pctl.mod.core
 * <br>   EnableResourceServer used
 * <br>   EnableDiscoveryClient used
 *
 * @author Begin Samuel
 */
@SpringBootApplication
@EnableResourceServer
@EnableDiscoveryClient
@ComponentScan({"com.centurylink.pctl.mod.user.domain.user", "com.centurylink.pctl.mod.core", "com.centurylink.pctl.mod.user"})
public class PctlUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(PctlUserApplication.class, args);
    }

    @LoadBalanced
    @Bean(name = "normalRestTemplate")
    public RestTemplate loadBalancedRestTemplate() {
        return new RestTemplate();
    }


}
