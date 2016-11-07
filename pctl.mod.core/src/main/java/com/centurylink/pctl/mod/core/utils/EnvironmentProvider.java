package com.centurylink.pctl.mod.core.utils;

import com.centurylink.pctl.mod.core.cons.Profiles;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * EnvironmentProvider class
 * Created by Begin Samuel
 */
@Component("environmentProvider")
public class EnvironmentProvider implements EnvironmentAware {

    /**
     * environment
     */
    private static Environment environment;

    /**
     * isProduction()
     * @return boolean
     */
    @Cacheable("EnvironmentProvider.isProduction")
    public Boolean isProduction() {
        return environment.acceptsProfiles(Profiles.PROD.getProfileName());
    }

    /**
     * isDevelopment()
     * @return boolean
     */
    @Cacheable("EnvironmentProvider.isDevelopment")
    public Boolean isDevelopment() {
        return environment.acceptsProfiles(Profiles.DEV.getProfileName());
    }

    /**
     * setEnvironment()
     * @param environment
     */
    @Override
    public void setEnvironment(Environment environment) {
        EnvironmentProvider.environment = environment;
    }
}
