package org.celllife.hl7;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.celllife.hl7.domain.CodedElement;
import org.celllife.hl7.domain.Identifier;
import org.celllife.hl7.domain.Patient;
import org.celllife.hl7.tables.Acknowledgements;

import ca.uhn.hl7v2.model.AbstractPrimitive;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.v251.datatype.CE;
import ca.uhn.hl7v2.model.v251.datatype.CWE;
import ca.uhn.hl7v2.model.v251.datatype.CX;
import ca.uhn.hl7v2.model.v251.segment.MSH;
import ca.uhn.hl7v2.model.v251.segment.PID;

public abstract class AbstractHl7 {
	
	public static final String DATE_FULL = "yyyyMMddHHmmss";
	public static final String DATE_DAY = "yyyyMMdd";
	public static final String APPLICATION_ID = "IDART";
	public static String FIELD_SEPARATOR = "|";
	public static String ENCODING_CHARACTERS = "^~\\&";
	
	protected void populateMSH(Messages type, MSH msh, Date messageDateTime,
			Acknowledgements acceptAck, Acknowledgements applicationAck) {
		try {
			msh.getFieldSeparator().setValue(FIELD_SEPARATOR);
			msh.getEncodingCharacters().setValue(ENCODING_CHARACTERS);
			msh.getSendingApplication().getNamespaceID().setValue(APPLICATION_ID);
			msh.getDateTimeOfMessage().getTime().setValue(formatDate(messageDateTime, DATE_FULL));
			msh.getMessageType().getMessageCode().setValue(type.code);
			msh.getMessageType().getTriggerEvent().setValue(type.event);
			msh.getMessageType().getMessageStructure().setValue(type.structure);
			msh.getAcceptAcknowledgmentType().setValue(acceptAck.name());
			msh.getApplicationAcknowledgmentType().setValue(applicationAck.name());
			msh.getProcessingID().getProcessingID().setValue("P");
			msh.getVersionID().getVersionID().setValue("2.5.1");
		} catch (DataTypeException e) {
			throw new RuntimeException(e);
		}
	}
	
	protected String formatDate(Date date, String format) {
		if (date == null)
			return null;
		
		return  new SimpleDateFormat(format).format(date);
	}

	protected void populatePID(PID pid, Patient patient){
		try {
			pid.getPatientName(0).getFamilyName().getSurname().setValue(patient.getSurname());
			pid.getPatientName(0).getGivenName().setValue(patient.getGivenName());
			
			int count = 0;
			for (Identifier id : patient.getIdentifiers()) {
				if (id.getValue() != null && id.getTypeCode() != null){
					CX cx = pid.getPatientIdentifierList(count);
					cx.getIDNumber().setValue(id.getValue());
					cx.getIdentifierTypeCode().setValue(id.getTypeCode().name());
					count++;
				}
			}
			pid.getDateTimeOfBirth().getTime().setValue(formatDate(patient.getDateOfBirth(), DATE_DAY));
			pid.getAdministrativeSex().setValue(String.valueOf(patient.getSex()));
		} catch (DataTypeException e) {
			throw new RuntimeException(e);
		}
	}
	
	protected void populateIfNotEmpty(AbstractPrimitive ap, Object value) throws DataTypeException{
		if (value == null)
			return;
		
		ap.setValue(value.toString());
	}
	
	protected void populateCE(CE ce, CodedElement e) throws DataTypeException{
		if (e == null)
			return;
			
		ce.getIdentifier().setValue(e.getCodeId());
		ce.getText().setValue(e.getCodeText());
		ce.getNameOfCodingSystem().setValue(e.getCodeSystemId());
	}
	
	protected void populateCWE(CWE cwe, CodedElement e) throws DataTypeException{
		if (e == null)
			return;
		
		cwe.getIdentifier().setValue(e.getCodeId());
		cwe.getText().setValue(e.getCodeText());
		cwe.getNameOfCodingSystem().setValue(e.getCodeSystemId());
	}
}
