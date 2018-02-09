package org.celllife.hl7;

import java.util.Arrays;
import java.util.Date;

import org.celllife.hl7.domain.CodedElement;
import org.celllife.hl7.domain.Dispense;
import org.celllife.hl7.domain.IdentifiablePerson;
import org.celllife.hl7.domain.Identifier;
import org.celllife.hl7.domain.Order;
import org.celllife.hl7.domain.Patient;
import org.celllife.hl7.tables.IdentifierTypeCode;
import org.celllife.hl7.tables.OrderControl;
import org.celllife.hl7.tables.Sex;
import org.celllife.hl7.validation.ValidationException;
import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;

public class RDS_O13test {

	@Test
	public void testRDS_O13() throws HL7Exception, ValidationException {
		Patient p = new Patient("Blogs", "Joe", new Date(), Sex.M);
		p.getIdentifiers().add(new Identifier("123", IdentifierTypeCode.FI));
		p.getIdentifiers().add(new Identifier("456", IdentifierTypeCode.TE));

		IdentifiablePerson provider = new IdentifiablePerson("Pharm", "Mary");
		provider.getIdentifiers().add(
				new Identifier("987", IdentifierTypeCode.RPH));
		Dispense d = new Dispense();
		d.setAmount(10);
		d.setCode(new CodedElement("JB123AB", "Tenofovir", "ATC"));
		d.setDate(new Date());
		d.setRepeatCounter(1);
		d.setUnits(new CodedElement("TAB", "Tablet", "ISO"));
		d.setPresciptionNumber("123ABC");
		d.setRefillsRemaining(2);
		Order order1 = new Order(OrderControl.RE, "ABC", "123ABC", provider, d);
		Order order2 = new Order(OrderControl.RE, "ABC", "123ABC", provider, d);
		RDS_O13 rds_O13 = new RDS_O13(new Date(), p, Arrays.asList(order1, order2));

		Parser parser = new PipeParser();
		String encodedMessage = parser.encode(rds_O13.getMessage());
		System.out.println(encodedMessage);
	}
}
