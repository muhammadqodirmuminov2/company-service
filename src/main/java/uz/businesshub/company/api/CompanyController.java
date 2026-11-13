package uz.businesshub.company.api;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.businesshub.company.api.dto.CompanyResponse;
import uz.businesshub.company.api.dto.RegisterCompanyRequest;
import uz.businesshub.company.service.CompanyService;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    @PreAuthorize("hasRole('PLATFORM_ADMIN')")
    public ResponseEntity<CompanyResponse> register(@Valid @RequestBody RegisterCompanyRequest request) {
        CompanyResponse created = companyService.register(request);
        return ResponseEntity.created(URI.create("/api/v1/companies/" + created.id())).body(created);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('PLATFORM_ADMIN') or @tenantGuard.isOwnCompany(#id)")
    public CompanyResponse getById(@PathVariable UUID id) {
        return companyService.getById(id);
    }
}