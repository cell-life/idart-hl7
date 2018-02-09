package org.celllife.hl7.validation;

public class ValidationError {

	public final String element;
	public final String message;
	
	public ValidationError(String element, String message) {
		super();
		this.element = element;
		this.message = message;
	}

	@Override
	public String toString() {
		return "[element=" + element + ", message=" + message
				+ "]";
	}
}
