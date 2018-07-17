package validation.prejava8;


/**
 * Details of a failed validation.
 * 
 * @author AbK
 *
 */
public class ValidationFailedObject {
	public ValidationFailedObject(String string) {
		this.message = string;
	}

	private String message;
}