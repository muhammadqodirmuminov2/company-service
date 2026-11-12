package uz.businesshub.company.exception;

import java.util.UUID;

public class CompanyNotFoundException extends RuntimeException {
    public CompanyNotFoundException(UUID id) { super("Company not found: " + id); }
}