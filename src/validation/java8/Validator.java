package validation.java8;

import java.util.Optional;

@FunctionalInterface
interface Validator {
	/**
	 * Validate input String
	 * 
	 * @return An Optional containing error message or an empty Optional when
	 *         validation is successful.
	 */
	Optional<ValidationFailedObject> validate(String input);
}