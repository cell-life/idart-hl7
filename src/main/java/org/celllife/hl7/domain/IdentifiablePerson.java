package org.celllife.hl7.domain;

import java.util.ArrayList;
import java.util.List;

import org.celllife.hl7.validation.CanValidateNamed;
import org.celllife.hl7.validation.ValidationError;
import org.celllife.hl7.validation.Validator;

public class IdentifiablePerson implements CanValidateNamed {

	private String surname;
	private String givenName;
	private List<Identifier> identifiers;

	public IdentifiablePerson(String surname, String givenName) {
		super();
		this.surname = surname;
		this.givenName = givenName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public Identifier getIdentifier(int index) {
		padIdentifiers(index+1);
		return getIdentifiers().get(index);
	}

	private void padIdentifiers(int size) {
		int numToAdd = size - this.getIdentifiers().size();
		if (numToAdd < 0) {
			numToAdd = 0;
		}

		for (int i = 0; i < numToAdd; i++) {
			this.getIdentifiers().add(new Identifier());
		}
	}

	public List<Identifier> getIdentifiers() {
		if (identifiers == null) {
			identifiers = new ArrayList<Identifier>();
		}
		return identifiers;
	}

	public void setIdentifiers(List<Identifier> identifiers) {
		this.identifiers = identifiers;
	}

	@Override
	public List<ValidationError> validate(String name) {
		Validator v = new Validator(name);
		v.isNotEmpty("Surname", surname);
		v.isNotEmpty("Given Name", givenName);
		v.isNotEmpty("Identifiers", identifiers);
		v.validate("Identifier", identifiers, false);
		return v.getErrors();
	}

}