package com.centurylink.pctl.mod.core.security.config;



//import com.centurylink.pctl.mod.core.security.utils.JwtTokenUtil;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * SpringSecurityAuditorAware class
 * @author Begin
 * Implementation of AuditorAware based on Spring Security.
 */
//@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {

    /**
     * overridden getCurrentAuditor()
     * @return userName
     */
    @Override
    public String getCurrentAuditor() {
        String userName = "test";
     //   String userName = JwtTokenUtil.getCurrentUserLogin();
        return (userName != null ? userName : "");
    }
}
