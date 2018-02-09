package org.celllife.hl7.tables;

public enum SubstitutionStatus {
	
	G(9, "A generic substitution was dispensed."),
	N(10, "No substitute was dispensed.  This is equivalent to the default (null) value."),
	T(11, "A therapeutic substitution was dispensed.");
	
	public final int order;
	public final String description;

	private SubstitutionStatus(int order, String description) {
		this.order = order;
		this.description = description;
	}

	
}
