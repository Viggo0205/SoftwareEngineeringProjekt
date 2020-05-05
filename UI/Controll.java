
public class Controll {
	
	private static String employees[] = new String[]{"CHJA", "CLLO", "EILA", "RANY", "VIOL"};
	public static boolean ready;
	private String[] sQueue;

	
	public static void main(String[] args) {		
		Thread t = new Thread(new Communicator());
		t.start();
		Login.menu();		
	}

	public static boolean isEmployee(String initialer) {
		for(int i = 0 ; i < employees.length ; i++)
			if(employees[i].equalsIgnoreCase(initialer))
				return true;
		return false;
	}

	public static void loggedIn() {
		UserInterface.menu();
		
	}
	
	public static void msgQueue(String[] sa) {
		ready = false;
		System.out.println(sa[0] + sa[1] + "sat i msgQueue");
		sQueue = sa;
	}
	//pls git
}