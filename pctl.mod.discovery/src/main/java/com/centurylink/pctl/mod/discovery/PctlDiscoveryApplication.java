package com.centurylink.pctl.mod.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * PctlDiscoveryApplication is a main class configured using @SpringBootApplication
 * Created by Begin Samuel
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@EnableEurekaServer
public class PctlDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(PctlDiscoveryApplication.class, args);
    }

}
