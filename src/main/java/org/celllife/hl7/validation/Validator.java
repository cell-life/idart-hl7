package org.celllife.hl7.validation;

import java.util.ArrayList;
import java.util.List;

public class Validator {

	private List<ValidationError> errors;
	private final String name;

	public Validator(String name) {
		this.name = name;
		errors = new ArrayList<ValidationError>();
	}

	private void addError(String fieldname, String message) {
		errors.add(new ValidationError(name + ": " + fieldname, message));
	}
	
	public List<ValidationError> getErrors() {
		return errors;
	}
	
	public boolean isGt(String fieldname, Integer element, Integer limit){
		if (!isNotNull(fieldname, element)){
			return false;
		}
		
		if (element <= limit) {
			addError(fieldname, "Field must be greater than " + limit);
			return false;
		}
		return true;
	}

	public boolean isNotEmpty(String fieldname, List<?> list) {
		if (!isNotNull(fieldname, list)){
			return false;
		}
		
		if (list.isEmpty()){
			addError(fieldname, "List is empty");
			return false;
		}
		return true;
	}

	public boolean isNotEmpty(String fieldname, String element){
		if (!isNotNull(fieldname, element)){
			return false;
		}
		
		if (element.isEmpty()) {
			addError(fieldname, "Field is empty");
			return false;
		}
		return true;
	}

	public boolean isNotNull(String fieldname, Object element) {
		if (element == null) {
			addError(fieldname, "Field is null");
			return false;
		}
		return true;
	}

	public void validate(String fieldname, CanValidate v) {
		if (isNotNull(fieldname, v))
			errors.addAll(v.validate());
	}

	public void validate(String fieldname, CanValidateNamed v) {
		if (isNotNull(fieldname, v))
			errors.addAll(v.validate(fieldname));
	}

	public void validate(String name, List<? extends CanValidateNamed> list, boolean allowNullOrEmpty) {
		if (allowNullOrEmpty && (list == null || list.isEmpty())) {
			return;
		}
		
		if (!isNotEmpty(name, list)){
			return;
		}
		
		for (CanValidateNamed v : list) {
			errors.addAll(v.validate(name));
		}
	}
}
