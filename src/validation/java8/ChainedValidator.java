package validation.java8;

import java.util.Optional;

public class ChainedValidator implements Validator{

	private static final int MINIMUM_LENGTH = 8;

	public Optional<ValidationFailedObject> validate(final String userInput) {

		return validateUsing(minimumLengthValidator(), userInput).map(Optional::of)
				.orElseGet(
						() -> validateUsing(numericCharactersValidator(),
								userInput)).map(Optional::of)
				.orElseGet(
						() -> validateUsing(upperCaseCharactersValidator(),
								userInput));
	}

	private Validator numericCharactersValidator() {
		return input -> input.matches(".*\\d+.*") ? Optional.empty() : Optional
				.of(new ValidationFailedObject("Should contain at least a digit"));
	}

	private Validator upperCaseCharactersValidator() {
		return input -> input.matches(".*[A-Z]+.*") ? Optional.empty()
				: Optional.of(new ValidationFailedObject("Should contain an upper case letter"));
	}

	private Validator minimumLengthValidator() {
		return input -> (input != null && input.length() > MINIMUM_LENGTH) ? Optional
				.empty() : Optional.of(new ValidationFailedObject(
				"Required min. length at least " + MINIMUM_LENGTH + " characters."));
	}

	private Optional<ValidationFailedObject> validateUsing(Validator validator,
			String userInput) {
		return validator.validate(userInput);
	}
	
	public static void main(String[] args) {
		ValidationFailedObject validate1 = new ChainedValidator().validate(
				"abc").orElse(new ValidationFailedObject("1 invalid"));
		ValidationFailedObject validate2 = new ChainedValidator().validate(
				"abcdeff12").orElse(new ValidationFailedObject("2 invalid"));
		ValidationFailedObject validate3 = new ChainedValidator().validate(
				"abcfffCef").orElse(new ValidationFailedObject("3 invalid"));
		ValidationFailedObject validate4 = new ChainedValidator().validate(
				"abcCeff12").orElse(new ValidationFailedObject("4 invalid"));
		
	}
}
