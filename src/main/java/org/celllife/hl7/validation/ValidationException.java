package org.celllife.hl7.validation;

import java.util.List;

public class ValidationException extends Exception {

	private static final long serialVersionUID = -4690925060594483736L;

	private final List<ValidationError> errors;
	
	public ValidationException(List<ValidationError> errors) {
		this.errors = errors;
	}
	
	public List<ValidationError> getErrors() {
		return errors;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("{ ");
		for (ValidationError e : errors) {
			sb.append(e.toString());
		}
		sb.append("}");
		return sb.toString();
	}
}
