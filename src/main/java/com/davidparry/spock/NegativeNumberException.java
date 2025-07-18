package com.davidparry.spock;

/**
 * Exception thrown to indicate that a value is zero or negative when a strictly positive value is required.
 * <p>
 * This exception is typically thrown by validation routines that check for positive numbers.
 * If the value being validated is less than or equal to zero, a {@code NegativeNumberException}
 * should be thrown to signal the validation failure.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 *     if (value <= 0) {
 *         throw new NegativeNumberException("Value must be greater than zero");
 *     }
 * </pre>
 * </p>
 *
 * @see ValidatorException
 */
public class NegativeNumberException extends ValidatorException {

    /**
     * Constructs a new NegativeNumberException with the specified detail message.
     *
     * @param message the detail message explaining why the value was considered invalid
     */
    public NegativeNumberException(String message) {
        super(message);
    }
}