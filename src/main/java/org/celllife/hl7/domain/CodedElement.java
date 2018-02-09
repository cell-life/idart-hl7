package org.celllife.hl7.domain;

import java.util.List;

import org.celllife.hl7.validation.CanValidateNamed;
import org.celllife.hl7.validation.ValidationError;
import org.celllife.hl7.validation.Validator;

public class CodedElement implements CanValidateNamed {

	private String codeId;
	private String codeText;
	private String codeSystemId;
	
	public CodedElement(String codeId, String codeText, String codeSystemId) {
		super();
		this.codeId = codeId;
		this.codeText = codeText;
		this.codeSystemId = codeSystemId;
	}

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public String getCodeText() {
		return codeText;
	}

	public void setCodeText(String codeText) {
		this.codeText = codeText;
	}

	public String getCodeSystemId() {
		return codeSystemId;
	}

	public void setCodeSystemId(String codeSystemId) {
		this.codeSystemId = codeSystemId;
	}

	@Override
	public List<ValidationError> validate(String name) {
		Validator v = new Validator(name);
		v.isNotEmpty("Code ID", codeId);
		v.isNotEmpty("Code system ID", codeSystemId);
		return v.getErrors();
	}

}
