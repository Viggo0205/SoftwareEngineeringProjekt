package Exceptions;

public class InitialsWrongLengthException extends Exception {
	public InitialsWrongLengthException() {
		super("Initialer skal være 4 tegn lange");
	}
}
