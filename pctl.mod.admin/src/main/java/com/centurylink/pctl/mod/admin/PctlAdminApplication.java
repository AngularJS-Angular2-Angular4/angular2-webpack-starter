package com.centurylink.pctl.mod.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import de.codecentric.boot.admin.config.EnableAdminServer;

/**
 * PctlAdminApplication class contains main method to run as SpringBootApplication
 *
 * @author Tarun Kumar Sukhu
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class PctlAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(PctlAdminApplication.class, args);
    }

}
