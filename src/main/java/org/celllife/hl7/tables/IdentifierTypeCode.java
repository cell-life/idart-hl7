package org.celllife.hl7.tables;

public enum IdentifierTypeCode {
	
//	AM(1, "American Express"),
//	AN(2, "Account number"),
//	ANC(3, "Account number Creditor"),
//	AND(4, "Account number debitor"),
//	ANON(5, "Anonymous identifier"),
//	ANT(6, "Temporary Account Number"),
//	APRN(7, "Advanced Practice Registered Nurse number"),
//	BA(8, "Bank Account Number"),
//	BC(9, "Bank Card Number"),
	BR(10, "Birth registry number"),
//	BRN(11, "Breed Registry Number"),
//	CC(12, "Cost Center number"),
	CY(13, "County number"),
//	DDS(14, "Dentist license number"),
//	DEA(15, "Drug Enforcement Administration registration number"),
//	DFN(16, "Drug Furnishing or prescriptive authority Number"),
//	DI(17, "Diner's Club card"),
	DL(18, "Driver's license number"),
//	DN(19, "Doctor number"),
//	DO(20, "Osteopathic License number"),
//	DPM(21, "Podiatrist license number"),
//	DR(22, "Donor Registration Number"),
//	DS(23, "Discover Card"),
//	EI(24, "Employee number"),
//	EN(25, "Employer number"),
	FI(26, "Facility ID"),
//	GI(27, "Guarantor internal identifier"),
//	GL(28, "General ledger number"),
//	GN(29, "Guarantor external  identifier"),
	HC(30, "Health Card Number"),
//	IND(31, "Indigenous/Aboriginal"),
//	JHN(32, "Jurisdictional health number (Canada)"),
//	LI(33, "Labor and industries number"),
//	LN(34, "License number"),
//	LR(35, "Local Registry ID"),
//	MA(36, "Patient Medicaid number"),
//	MB(37, "Member Number"),
//	MC(38, "Patient's Medicare number"),
//	MCD(39, "Practitioner Medicaid number"),
//	MCN(40, "Microchip Number"),
//	MCR(41, "Practitioner Medicare number"),
//	MD(42, "Medical License number"),
//	MI(43, "Military ID number"),
	MR(44, "Medical record number"),
	MRT(45, "Temporary Medical Record Number"),
//	MS(46, "MasterCard"),
//	NE(47, "National employer identifier"),
	NH(48, "National Health Plan Identifier"),
//	NI(49, "National unique individual identifier"),
//	NII(50, "National Insurance Organization Identifier"),
//	NIIP(51, "National Insurance Payor Identifier (Payor)"),
//	NNxxx(52, "National Person Identifier where the xxx is the ISO table 3166 3-character (alphabetic) country code"),
//	NP(53, "Nurse practitioner number"),
//	NPI(54, "National provider identifier"),
//	OD(55, "Optometrist license number"),
//	PA(56, "Physician Assistant number"),
//	PCN(57, "Penitentiary/correctional institution Number"),
//	PE(58, "Living Subject Enterprise Number"),
//	PEN(59, "Pension Number"),
//	PI(60, "Patient internal identifier"),
//	PN(61, "Person number"),
//	PNT(62, "Temporary Living Subject Number"),
	PPN(63, "Passport number"),
	PRC(64, "Permanent Resident Card Number"),
//	PRN(65, "Provider number"),
//	PT(66, "Patient external identifier"),
//	QA(67, "QA number"),
//	RI(68, "Resource identifier"),
//	RN(69, "Registered Nurse Number"),
	RPH(70, "Pharmacist license number"),
//	RR(71, "Railroad Retirement number"),
//	RRI(72, "Regional registry ID"),
//	SL(73, "State license"),
//	SN(74, "Subscriber Number"),
//	SR(75, "State registry ID"),
//	SS(76, "Social Security number"),
//	TAX(77, "Tax ID number"),
//	TN(78, "Treaty Number/ (Canada)"),
//	U(79, "Unspecified identifier"),
//	UPIN(80, "Medicare/CMS (formerly HCFA)'s Universal Physician Identification numbers"),
//	VN(81, "Visit number"),
//	VS(82, "VISA"),
//	WC(83, "WIC identifier"),
//	WCN(84, "Workers' Comp Number"),
//	XX(85, "Organization identifier"),
	TE(86, "Therapy Edge Identifier"),
	;
	
	public final int order;
	public final String description;

	private IdentifierTypeCode(int order, String description) {
		this.order = order;
		this.description = description;
	}
}