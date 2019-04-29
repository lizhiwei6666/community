package cn.cmmunity.auth.config;

import jdk.nashorn.internal.runtime.regexp.joni.Config;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    public SecurityInitializer() {
        super(SessionConfig.class, Config.class);
    }
}
