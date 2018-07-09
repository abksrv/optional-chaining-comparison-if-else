package validation;

public class ChainedValidator implements Validator{

	private static final int MINIMUM_LENGTH = 8;

	public ValidationFailedObject validate(final String userInput) {

		ValidationFailedObject validationMinLengthFailed = validateUsing(
				minimumLengthValidator(), userInput);
		if (validationMinLengthFailed != null) {
			return validationMinLengthFailed;
		}
		ValidationFailedObject validationNumericFailed = validateUsing(
				numericCharactersValidator(), userInput);
		if (validationNumericFailed != null) {
			return validationNumericFailed;
		}
		ValidationFailedObject validationUpperCaseFailed = validateUsing(
				upperCaseCharactersValidator(), userInput);
		if (validationUpperCaseFailed != null) {
			return validationUpperCaseFailed;
		}
		return null;
	}

	private Validator numericCharactersValidator() {
		return input -> input.matches(".*\\d+.*") ? null
				: new ValidationFailedObject("Should contain at least a digit");
	}

	private Validator upperCaseCharactersValidator() {
		return input -> input.matches(".*[A-Z]+.*") ? null
				: new ValidationFailedObject(
						"Should contain an upper case letter");
	}

	private Validator minimumLengthValidator() {
		return input -> (input != null && input.length() > MINIMUM_LENGTH) ? null
				: new ValidationFailedObject("Required min. length at least "
						+ MINIMUM_LENGTH + " characters.");
	}

	private ValidationFailedObject validateUsing(Validator validator,
			String userInput) {
		return validator.validate(userInput);
	}
	
	public static void main(String[] args) {
		ValidationFailedObject validate1 = new ChainedValidator()
				.validate("abc");
		ValidationFailedObject validate2 = new ChainedValidator()
				.validate("abcdeff12");
		ValidationFailedObject validate3 = new ChainedValidator()
				.validate("abcfffCef");
		ValidationFailedObject validate4 = new ChainedValidator()
				.validate("abcCeff12");

	}
}
