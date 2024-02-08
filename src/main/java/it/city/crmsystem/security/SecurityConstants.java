package it.city.crmsystem.security;

public class SecurityConstants {
    public static final String[] WHITE_LIST = {
            "/auth/register",
            "/auth/login",
            "/attachment/**",
            "/api-docs/**",
            "/user/**",
            "/swagger-ui/**",
            "/v2/api-docs",
            "/swagger-ui.html",
            "/v3/api-docs",
            "/v3/api-docs/swagger-config",
            "/swagger-resources/**",
            "/webjars/**",
            "/**"
    };
}
