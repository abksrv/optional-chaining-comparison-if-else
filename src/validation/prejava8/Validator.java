package validation.prejava8;


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