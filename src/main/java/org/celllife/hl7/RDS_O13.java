package org.celllife.hl7;

import java.util.Date;
import java.util.List;

import org.celllife.hl7.domain.Dispense;
import org.celllife.hl7.domain.IdentifiablePerson;
import org.celllife.hl7.domain.Identifier;
import org.celllife.hl7.domain.Order;
import org.celllife.hl7.domain.Patient;
import org.celllife.hl7.tables.Acknowledgements;
import org.celllife.hl7.validation.ValidationError;
import org.celllife.hl7.validation.ValidationException;
import org.celllife.hl7.validation.Validator;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.v251.datatype.XCN;
import ca.uhn.hl7v2.model.v251.group.RDS_O13_ORDER;
import ca.uhn.hl7v2.model.v251.segment.MSH;
import ca.uhn.hl7v2.model.v251.segment.ORC;
import ca.uhn.hl7v2.model.v251.segment.PID;
import ca.uhn.hl7v2.model.v251.segment.RXD;

public class RDS_O13 extends AbstractHl7 {

	private final Messages type = Messages.RDS_O13;
	private ca.uhn.hl7v2.model.v251.message.RDS_O13 msg;
	private final Date messageDate;
	private final Patient patient;
	private final List<Order> orders;

	public RDS_O13(Date messageDate, Patient patient, List<Order> orders) throws ValidationException {
		this.messageDate = messageDate;
		this.patient = patient;
		this.orders = orders;
		
		generateHl7Message();
	}

	private void generateHl7Message() {
		msg = new ca.uhn.hl7v2.model.v251.message.RDS_O13();
		MSH msh = msg.getMSH();
		populateMSH(type, msh, messageDate, Acknowledgements.NE,
				Acknowledgements.AL);

		PID pid = msg.getPATIENT().getPID();
		populatePID(pid, patient);

		for (int i = 0; i < orders.size(); i++) {
			Order order = orders.get(i);
			RDS_O13_ORDER hl7order = msg.getORDER(i);
			ORC orc = hl7order.getORC();
			populateORC(orc, order);

			RXD rxd = hl7order.getRXD();
			populateRXD(rxd, order.getDispense());
		}
	}

	public void validate() throws ValidationException {
		Validator v = new Validator("RDS_O13");
		v.isNotNull("Message date", messageDate);
		if (v.isNotNull("Patient", patient))
			patient.validate();
		
		if (v.isNotEmpty("Orders", orders)) {
			for (Order o : orders) {
				v.validate("Order", o);
			}
		}
		List<ValidationError> errors = v.getErrors();
		if (!errors.isEmpty()){
			throw new ValidationException(errors);
		}
	}

	public ca.uhn.hl7v2.model.v251.message.RDS_O13 getMessage() {
		return msg;
	}

	protected void populateORC(ORC orc, Order order) {
		try {
			orc.getOrderControl().setValue(order.getControlCode().name());
			orc.getPlacerOrderNumber().getEi1_EntityIdentifier()
					.setValue(order.getPlacerOrderNumber());
			orc.getFillerOrderNumber().getEi1_EntityIdentifier()
					.setValue(order.getFillerOrderNumber());
			XCN orderingProvider = orc.getOrderingProvider(0);
			IdentifiablePerson op = order.getOrderingProvider();
			if (op != null){
				Identifier identifier = op.getIdentifier(0);
				if (identifier.getValue() != null
						&& !identifier.getValue().isEmpty()) {
					orderingProvider.getIDNumber().setValue(identifier.getValue());
					orderingProvider.getIdentifierTypeCode().setValue(
							identifier.getTypeCode().name());
				}
				orderingProvider.getFamilyName().getSurname()
					.setValue(op.getSurname());
				orderingProvider.getGivenName().setValue(op.getGivenName());
			}

		} catch (DataTypeException e) {
			throw new RuntimeException(e);
		}
	}

	private void populateRXD(RXD rxd, Dispense dispense) {
		try {
			rxd.getDispenseSubIDCounter().setValue(dispense.getRepeatCounter().toString());
			populateCE(rxd.getDispenseGiveCode(), dispense.getCode());
			rxd.getDateTimeDispensed().getTime().setValue(formatDate(dispense.getDate(), DATE_FULL));
			rxd.getActualDispenseAmount().setValue(dispense.getAmount().toString());
			populateCE(rxd.getActualDispenseUnits(), dispense.getUnits());
			rxd.getPrescriptionNumber().setValue(dispense.getPresciptionNumber());
			rxd.getNumberOfRefillsRemaining().setValue(dispense.getRefillsRemaining().toString());
			populateIfNotEmpty(rxd.getSubstitutionStatus(), dispense.getSubstitutionStatus());
			populateIfNotEmpty(rxd.getActualStrength(), dispense.getStrength());
			populateCE(rxd.getActualStrengthUnit(), dispense.getStrengthUnits());
			populateIfNotEmpty(rxd.getSubstanceLotNumber(0), dispense.getLotNumber());
			populateIfNotEmpty(rxd.getSubstanceExpirationDate(0).getTime(), formatDate(dispense.getExpirationDate(), DATE_DAY));
			populateIfNotEmpty(rxd.getDispensePackageSize(), dispense.getPacksize());
			populateCE(rxd.getDispensePackageSizeUnit(), dispense.getPacksizeUnits());
			populateIfNotEmpty(rxd.getActualDrugStrengthVolume(), dispense.getStrengthVolume());
			populateCWE(rxd.getActualDrugStrengthVolumeUnits(), dispense.getStrengthVolumeUnits());
		} catch (DataTypeException e) {
			throw new RuntimeException(e);
		}

	}

}
