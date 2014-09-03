package com.ccoew.onlinepayment.dateenum;

public enum Month {
	JAN(1),
	FEB(2),
	MAR(3),
	APR(4),
	MAY(5),
	JUNE(6),
	JULY(7),
	AUG(8),
	SEP(9),
	OCT(10),
	NOV(11),
	DEC(12);
	
	private int value;

	Month(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
