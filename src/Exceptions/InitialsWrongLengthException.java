package Exceptions;

public class InitialsWrongLengthException extends Exception {
	public InitialsWrongLengthException() {
		super("Initialer skal v�re 4 tegn lange");
	}
}
