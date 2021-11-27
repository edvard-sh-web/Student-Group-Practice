package lesson2;

public class GroupOverflowException extends Exception {

	public GroupOverflowException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GroupOverflowException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		return "The group is full. This student can't be added.";
	}

}
