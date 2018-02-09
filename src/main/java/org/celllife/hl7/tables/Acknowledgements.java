package org.celllife.hl7.tables;

public enum Acknowledgements {
	AL(1, "Always"),
	ER(2, "Error/reject conditions only"),
	NE(3, "Never"),
	SU(4, "Successful completion only");

	public final int order;
	public final String description;

	private Acknowledgements(int order, String description) {
		this.order = order;
		this.description = description;
	}
}