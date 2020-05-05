
public class Controll {

	private static String employees[] = new String[]{"CHJA", "CLLO", "EILA", "RANY", "VIOL"};
	public static boolean ready;
	private static String[] sQueue;
	public static String[] projektListe;
	private static String[] loginModt;


	public static void main(String[] args) {		
		Thread t = new Thread(new Communicator());
		t.start();
		Login.menu();

		while(true) {
			if(!ready) {
				if(sQueue[0].equals("placeholder")) { // modtagelse af projekt liste
					projektListe = sQueue[1].split(";");
					UserInterface.proListModt();
				} else if(sQueue[0].equals("placeholder2")) { // modtagelse af aktiviteter
					
				} else if(sQueue[0].equals("0")) { // svar login
					loginModt = sQueue[1].split(";");
					if(loginModt[0].equals("200")) { // godkendt login
						setDate(loginModt[1]);
						
					} else {
						//fejlet login
					}
					
					
					
				} else { // fejl i protokolkode
					System.out.println("ukendt protokolkode: " + sQueue[0]);
				}

			}
		}
	}

	private static void setDate(String datoString) {
		// TODO Auto-generated method stub
		
	}

	public static boolean isEmployee(String initialer) {
		for(int i = 0 ; i < employees.length ; i++)
			if(employees[i].equalsIgnoreCase(initialer))
				return true;
		return false;
	}

	public static void loggedIn() {
		Login.bund.setText("logget ind");
		UserInterface.menu();
	}

	public static void msgQueue(String[] sa) {
		ready = false;
		System.out.println(sa[0] + sa[1] + "sat i msgQueue");
		//sQueue = sa;
	}

	public void OpretAktiv(String projekt, String startUge, String slutUge, String timer) {
		Communicator.sendOpretAktiv(projekt, startUge, slutUge, timer);
	}
	//
}