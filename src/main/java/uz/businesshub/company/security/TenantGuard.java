package uz.businesshub.company.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("tenantGuard")
public class TenantGuard {

    public boolean isOwnCompany(UUID companyId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof JwtAuthenticationToken jwtAuth) || companyId == null) {
            return false;
        }
        return companyId.toString().equals(jwtAuth.getToken().getClaimAsString("company_id"));
    }
}