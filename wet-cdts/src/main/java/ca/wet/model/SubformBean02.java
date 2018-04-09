package ca.wet.model;

public class SubformBean02 {
	private Enum01 enum01choice = null;

	public Enum01 getEnum01Choice() {
		return enum01choice;
	}

	public void setEnum01Choice(final Enum01 enum01choice) {
		this.enum01choice = enum01choice;
	}
	
	public Enum01[] getEnum01Values() {
		return Enum01.values();
	}
}
