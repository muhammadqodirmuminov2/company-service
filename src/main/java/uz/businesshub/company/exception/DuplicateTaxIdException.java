package uz.businesshub.company.exception;

public class DuplicateTaxIdException extends RuntimeException {
    public DuplicateTaxIdException(String taxId) { super("Company with tax ID already exists: " + taxId); }
}