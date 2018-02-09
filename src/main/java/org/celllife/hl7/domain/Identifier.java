package org.celllife.hl7.domain;

import java.util.List;

import org.celllife.hl7.tables.IdentifierTypeCode;
import org.celllife.hl7.validation.CanValidateNamed;
import org.celllife.hl7.validation.ValidationError;
import org.celllife.hl7.validation.Validator;


public class Identifier implements CanValidateNamed {

	private String value;
	private IdentifierTypeCode typeCode;
	
	public Identifier() {
	}

	public Identifier(String value, IdentifierTypeCode typeCode) {
		this.value = value;
		this.typeCode = typeCode;
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public IdentifierTypeCode getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(IdentifierTypeCode typeCode) {
		this.typeCode = typeCode;
	}

	@Override
	public List<ValidationError> validate(String name) {
		Validator v = new Validator(name);
		v.isNotEmpty("Value", value);
		v.isNotNull("Type code", typeCode);
		return v.getErrors();
	}
}
