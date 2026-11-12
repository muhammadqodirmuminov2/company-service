package uz.businesshub.company.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.businesshub.company.api.dto.CompanyResponse;
import uz.businesshub.company.api.dto.RegisterCompanyRequest;
import uz.businesshub.company.domain.Company;
import uz.businesshub.company.exception.CompanyNotFoundException;
import uz.businesshub.company.exception.DuplicateTaxIdException;
import uz.businesshub.company.repository.CompanyRepository;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Transactional
    public CompanyResponse register(RegisterCompanyRequest request) {
        if (companyRepository.existsByTaxId(request.taxId())) {
            throw new DuplicateTaxIdException(request.taxId());
        }
        Company company = Company.register(request.name().trim(), request.taxId());
        companyRepository.save(company);
        return CompanyResponse.from(company);
    }

    public CompanyResponse getById(UUID id) {
        return companyRepository.findById(id)
                .map(CompanyResponse::from)
                .orElseThrow(() -> new CompanyNotFoundException(id));
    }
}