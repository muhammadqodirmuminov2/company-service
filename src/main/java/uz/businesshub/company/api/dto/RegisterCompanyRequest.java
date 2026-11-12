package uz.businesshub.company.api.dto;

import jakarta.validation.constraints.*;

public record RegisterCompanyRequest(
        @NotBlank @Size(max = 255) String name,
        @NotBlank @Pattern(regexp = "\\d{9}", message = "must be 9 digits") String taxId
) {}