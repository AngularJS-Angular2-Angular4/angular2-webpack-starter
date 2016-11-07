package com.centurylink.pctl.mod.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Begin Samuel
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
@EnableZuulProxy
@ComponentScan({"com.centurylink.pctl.mod.ui", "com.centurylink.pctl.mod.core"} )
public class PctlUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PctlUiApplication.class, args);
    }



  @LoadBalanced
  @Bean(name = "normalRestTemplate")
  public RestTemplate loadBalancedRestTemplate() {
    return new RestTemplate();
  }

}
