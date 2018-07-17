package validation.java8;

import java.util.Optional;

public class ChainedValidator implements Validator{

	private static final int MINIMUM_LENGTH = 8;

	public Optional<ValidationFailedObject> validate(final String userInput) {

		return validateUsing(minimumLengthValidator(), userInput).map(Optional::of)
				.orElseGet(() -> validateUsing(numericCharactersValidator(),
								userInput)).map(Optional::of)
				.orElseGet(() -> validateUsing(upperCaseCharactersValidator(),
								userInput));
		/*return validateUsing(minimumLengthValidator(), userInput)
				.or(() -> validateUsing(numericCharactersValidator(), userInput))
				.or(() -> validateUsing(upperCaseCharactersValidator(), userInput));*/
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
		Optional<ValidationFailedObject> validate = new ChainedValidator().validate("ZemenskyabC");
		validate.ifPresent(obj -> System.out.println(obj));
	}
}
