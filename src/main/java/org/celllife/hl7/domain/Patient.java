package org.celllife.hl7.domain;

import java.util.Date;
import java.util.List;

import org.celllife.hl7.tables.Sex;
import org.celllife.hl7.validation.CanValidate;
import org.celllife.hl7.validation.ValidationError;
import org.celllife.hl7.validation.Validator;


public class Patient extends IdentifiablePerson implements CanValidate {

	private Date dateOfBirth;
	private Sex sex;

	public Patient(String surname, String givenName, Date dateOfBirth,
			Sex sex) {
		super(surname, givenName);
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	@Override
	public List<ValidationError> validate() {
		List<ValidationError> errors = super.validate("Patient");
		Validator v = new Validator("Patient");
		v.isNotNull("Date of birth", dateOfBirth);
		v.isNotNull("Sex", sex);
		errors.addAll(v.getErrors());
		return errors;
	}
}
