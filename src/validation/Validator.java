package validation;


@FunctionalInterface
interface Validator {
	/**
	 * Validate input String
	 * 
	 * @return An error object or an empty Optional when
	 *         validation is successful.
	 */
	ValidationFailedObject validate(String input);
}