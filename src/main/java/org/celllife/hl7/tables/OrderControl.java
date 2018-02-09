package org.celllife.hl7.tables;

public enum OrderControl {
	
	AF(1, "Order/service refill request approval"),
	CA(2, "Cancel order/service request"),
	CH(3, "Child order/service"),
	CN(4, "Combined result"),
	CR(5, "Canceled as requested"),
	DC(6, "Discontinue order/service request"),
	DE(7, "Data errors"),
	DF(8, "Order/service refill request denied"),
	DR(9, "Discontinued as requested"),
	FU(10, "Order/service refilled, unsolicited"),
	HD(11, "Hold order request"),
	HR(12, "On hold as requested"),
	LI(13, "Link order/service to patient care problem or goal"),
	NA(14, "Number assigned"),
	NW(15, "New order/service"),
	OC(16, "Order/service canceled"),
	OD(17, "Order/service discontinued"),
	OE(18, "Order/service released"),
	OF(19, "Order/service refilled as requested"),
	OH(20, "Order/service held"),
	OK(21, "Order/service accepted & OK"),
	OP(22, "Notification of order for outside dispense"),
	OR(23, "Released as requested"),
	PA(24, "Parent order/service"),
	PR(25, "Previous Results with new order/service"),
	PY(26, "Notification of replacement order for outside dispense"),
	RE(27, "Observations/Performed Service to follow"),
	RF(28, "Refill order/service request"),
	RL(29, "Release previous hold"),
	RO(30, "Replacement order"),
	RP(31, "Order/service replace request"),
	RQ(32, "Replaced as requested"),
	RR(33, "Request received"),
	RU(34, "Replaced unsolicited"),
	SC(35, "Status changed"),
	SN(36, "Send order/service number"),
	SR(37, "Response to send order/service status request"),
	SS(38, "Send order/service status request"),
	UA(39, "Unable to accept order/service"),
	UC(40, "Unable to cancel"),
	UD(41, "Unable to discontinue"),
	UF(42, "Unable to refill"),
	UH(43, "Unable to put on hold"),
	UM(44, "Unable to replace"),
	UN(45, "Unlink order/service from patient care problem or goal"),
	UR(46, "Unable to release"),
	UX(47, "Unable to change"),
	XO(48, "Change order/service request"),
	XR(49, "Changed as requested"),
	XX(50, "Order/service changed, unsol."),
	;
	
	public final int order;
	public final String description;

	private OrderControl(int order, String description) {
		this.order = order;
		this.description = description;
	}

}
