package org.celllife.hl7.validation;

import java.util.List;


public interface CanValidate {
	public List<ValidationError> validate();
}
