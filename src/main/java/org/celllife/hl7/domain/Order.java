package org.celllife.hl7.domain;

import java.util.List;

import org.celllife.hl7.tables.OrderControl;
import org.celllife.hl7.validation.CanValidate;
import org.celllife.hl7.validation.ValidationError;
import org.celllife.hl7.validation.Validator;


public class Order implements CanValidate {

	private OrderControl controlCode;
	private String placerOrderNumber;
	private String fillerOrderNumber;
	private IdentifiablePerson orderingProvider;
	private Dispense dispense;

	public Order(OrderControl controlCode, String placerOrderNumber,
			String fillerOrderNumber, IdentifiablePerson orderingProvider,
			Dispense dispense) {
		super();
		this.controlCode = controlCode;
		this.placerOrderNumber = placerOrderNumber;
		this.fillerOrderNumber = fillerOrderNumber;
		this.orderingProvider = orderingProvider;
		this.setDispense(dispense);
	}

	public String getPlacerOrderNumber() {
		return placerOrderNumber;
	}

	public void setPlacerOrderNumber(String placerOrderNumber) {
		this.placerOrderNumber = placerOrderNumber;
	}

	public String getFillerOrderNumber() {
		return fillerOrderNumber;
	}

	public void setFillerOrderNumber(String fillerOrderNumber) {
		this.fillerOrderNumber = fillerOrderNumber;
	}

	public IdentifiablePerson getOrderingProvider() {
		return orderingProvider;
	}

	public void setOrderingProvider(IdentifiablePerson orderingProvider) {
		this.orderingProvider = orderingProvider;
	}

	public void setControlCode(OrderControl controlCode) {
		this.controlCode = controlCode;
	}

	public OrderControl getControlCode() {
		return controlCode;
	}

	public void setDispense(Dispense dispense) {
		this.dispense = dispense;
	}

	public Dispense getDispense() {
		return dispense;
	}

	@Override
	public List<ValidationError> validate() {
		Validator v = new Validator("Order");
		v.isNotNull("Control code", controlCode);
		v.isNotEmpty("Placer order number", placerOrderNumber);
		if (orderingProvider != null)
			v.validate("Ordering provider",orderingProvider);
		v.validate("Dispense", dispense);
		return v.getErrors();
	}

}
