
public class Controll {
	
	private static String employees[] = new String[]{"CHJA", "CLLO", "EILA", "RANY", "VIOL"};
	private static String loggedInit;
	
	public static void main(String[] args) {		
//		Thread t = new Thread(new Comunicator???()); ///////////////////////// help
//		t.start();
		Login.menu();
		
		// something something if loggedInit > 0 login ////////////
		// UserInterface.menu();
		
	}

	public static boolean isEmployee(String initialer) {
		for(int i = 0 ; i < employees.length ; i++)
			if(employees[i].equalsIgnoreCase(initialer))
				return true;
		return false;
	}

	public static void setInit(String initialer) {
		loggedInit = initialer;
	}
}