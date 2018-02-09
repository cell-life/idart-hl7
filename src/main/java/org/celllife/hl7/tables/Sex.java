package org.celllife.hl7.tables;

public enum Sex {
	A(1, "Ambiguous"),
	F(2, "Female"),
	M(3, "Male"),
	N(4, "Not applicable"),
	O(5, "Other"),
	U(6, "Unknown");

	public final int order;
	public final String description;

	private Sex(int order, String description) {
		this.order = order;
		this.description = description;
	}
}