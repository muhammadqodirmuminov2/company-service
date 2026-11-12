package uz.businesshub.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.businesshub.company.domain.Company;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
    boolean existsByTaxId(String taxId);
}