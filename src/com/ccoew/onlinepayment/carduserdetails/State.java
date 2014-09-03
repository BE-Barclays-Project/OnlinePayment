package com.ccoew.onlinepayment.carduserdetails;

import com.ccoew.onlinepayment.validations.Validator;

public class State {
	private String state;

	public static State stateCreater(String state) {
		State state1 = new State(state);
		if (state1.isValid()) {
			return state1;
		} else {
			return null;
		}
	}

	private State(String state) {
		super();
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "State [state=" + state + "]";
	}

	public boolean isValid() {
		return (Validator.isValidName(getState()));
	}

}
