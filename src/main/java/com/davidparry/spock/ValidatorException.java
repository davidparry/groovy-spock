package com.davidparry.spock;

/**
 * Top-level exception for validation errors within the framework.
 * <p>
 * This exception is intended to be thrown whenever a validation operation fails.
 * It serves as a common base for all validation-related exceptions, allowing
 * framework users to catch and handle validation errors in a unified way.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 *     if (!isValid(input)) {
 *         throw new ValidatorException("Input is invalid");
 *     }
 * </pre>
 * </p>
 */
public class ValidatorException extends RuntimeException {
    /**
     * Constructs a new ValidatorException with the specified detail message.
     *
     * @param message the detail message explaining the reason for the validation failure
     */
    public ValidatorException(String message) {
        super(message);
    }
}