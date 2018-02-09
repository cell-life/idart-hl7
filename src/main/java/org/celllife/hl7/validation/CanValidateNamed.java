package org.celllife.hl7.validation;

import java.util.List;


public interface CanValidateNamed {
	public List<ValidationError> validate(String name);
}
