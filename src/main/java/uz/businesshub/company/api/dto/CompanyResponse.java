package uz.businesshub.company.api.dto;

import uz.businesshub.company.domain.Company;
import uz.businesshub.company.domain.CompanyStatus;
import java.time.Instant;
import java.util.UUID;

public record CompanyResponse(UUID id, String name, String taxId,
                              CompanyStatus status, Instant createdAt) {
    public static CompanyResponse from(Company c) {
        return new CompanyResponse(c.getId(), c.getName(), c.getTaxId(),
                c.getStatus(), c.getCreatedAt());
    }
}