package Exceptions;

public class EmployeeAlreadyExistsException extends Exception {
	public EmployeeAlreadyExistsException() {
		super("Der findes allerede en medarbejder med de givne initialer");
			}

}
