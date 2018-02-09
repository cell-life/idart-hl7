package org.celllife.hl7.domain;

import java.util.Date;
import java.util.List;

import org.celllife.hl7.tables.SubstitutionStatus;
import org.celllife.hl7.validation.CanValidate;
import org.celllife.hl7.validation.ValidationError;
import org.celllife.hl7.validation.Validator;

public class Dispense implements CanValidate {
	
	private Integer repeatCounter;
	private CodedElement code;
	private Date date;
	private Integer amount;
	private CodedElement units;
	private String presciptionNumber;
	private Integer refillsRemaining;
	private SubstitutionStatus substitutionStatus;
	private Integer strength;
	private CodedElement strengthUnits;
	private String lotNumber;
	private Date expirationDate;
	private Integer packsize;
	private CodedElement packsizeUnits;
	private Integer strengthVolume;
	private CodedElement strengthVolumeUnits;

	public Integer getRepeatCounter() {
		return repeatCounter;
	}

	public void setRepeatCounter(Integer repeatCounter) {
		this.repeatCounter = repeatCounter;
	}

	public CodedElement getCode() {
		return code;
	}

	public void setCode(CodedElement code) {
		this.code = code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public CodedElement getUnits() {
		return units;
	}

	public void setUnits(CodedElement units) {
		this.units = units;
	}

	public String getPresciptionNumber() {
		return presciptionNumber;
	}

	public void setPresciptionNumber(String presciptionNumber) {
		this.presciptionNumber = presciptionNumber;
	}

	public Integer getRefillsRemaining() {
		return refillsRemaining;
	}

	public void setRefillsRemaining(Integer refillsRemaining) {
		this.refillsRemaining = refillsRemaining;
	}

	public SubstitutionStatus getSubstitutionStatus() {
		return substitutionStatus;
	}

	public void setSubstitutionStatus(SubstitutionStatus substitutionStatus) {
		this.substitutionStatus = substitutionStatus;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public CodedElement getStrengthUnits() {
		return strengthUnits;
	}

	public void setStrengthUnits(CodedElement strengthUnits) {
		this.strengthUnits = strengthUnits;
	}

	public String getLotNumber() {
		return lotNumber;
	}

	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Integer getPacksize() {
		return packsize;
	}

	public void setPacksize(Integer packsize) {
		this.packsize = packsize;
	}

	public CodedElement getPacksizeUnits() {
		return packsizeUnits;
	}

	public void setPacksizeUnits(CodedElement packsizeUnits) {
		this.packsizeUnits = packsizeUnits;
	}

	public Integer getStrengthVolume() {
		return strengthVolume;
	}

	public void setStrengthVolume(Integer strengthVolume) {
		this.strengthVolume = strengthVolume;
	}

	public CodedElement getStrengthVolumeUnits() {
		return strengthVolumeUnits;
	}

	public void setStrengthVolumeUnits(CodedElement strengthVolumeUnits) {
		this.strengthVolumeUnits = strengthVolumeUnits;
	}
	
	public List<ValidationError> validate(){
		Validator v = new Validator("Dispense");
		v.isGt("Repeat counter", repeatCounter, 0);
		v.validate("Code",code);
		v.isNotNull("date", date);
		v.isGt("amount", amount, 0);
		v.validate("units", units);
		v.isNotEmpty("Prescription number", presciptionNumber);
		v.isNotNull("Repeats remaining", refillsRemaining);
		if (strength != null)
			v.validate("Strength units", strengthUnits);
		if (packsize != null)
			v.validate("Packsize units", packsizeUnits);
		if (strengthVolume != null)
			v.validate("Strength volume units", strengthVolumeUnits);
		
		return v.getErrors();
	}

}
