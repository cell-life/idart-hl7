package org.celllife.hl7;

public enum Messages {
	RDS_O13("RDS","O13","RDS_O13");
	
	public final String code;
	public final String event;
	public final String structure;

	private Messages(String code, String event, String structure){
		this.code = code;
		this.event = event;
		this.structure = structure;
	}
}