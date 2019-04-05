package demo.jmockit;

public class SubClass extends SuperClass{

	private String input;
	
	public SubClass(String input) {
		super();
		this.input = input;
	}

	public Object getInput() {
		return input;
	}
}
