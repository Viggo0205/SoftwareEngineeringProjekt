
import static org.junit.Assert.*;

import org.junit.Test;

import SoftwareEngineringProjekt.src.Aktivitet;
import SoftwareEngineringProjekt.src.Arbejdsdag;
import SoftwareEngineringProjekt.src.Dato;

public class ArbejdsdagTest {

	@org.junit.Test
	public void addTid() {
    	Arbejdsdag arbejdsdag = new Arbejdsdag(new Dato(2020, 3));
    	
    	arbejdsdag.addTid("projekt", "aktivitet", 2);
    	
    	assertEquals(arbejdsdag.getTid(),arbejdsdag.getTid());
	}

	@org.junit.Test
	public void getTid() {
    	Arbejdsdag arbejdsdag = new Arbejdsdag(new Dato(2020, 3));
    	
    	arbejdsdag.addTid("projekt", "aktivitet", 2);
    	
    	assertEquals(arbejdsdag.getTid(),arbejdsdag.getTid());
	}
	
	@org.junit.Test
	public void findProjInd() {
		Arbejdsdag arbejdsdag = new Arbejdsdag(new Dato(3,2020));
				
		arbejdsdag.findProjInd("projekt");
		
		assertEquals(arbejdsdag.findProjInd("projekt"), arbejdsdag.findProjInd("projekt"));
	}
	
	
	@org.junit.Test
	public void findAktInd() {
		Arbejdsdag arbejdsdag = new Arbejdsdag(new Dato(3,2020));
		
		arbejdsdag.addTid("Proj1", "aktivitet", 3);

		arbejdsdag.findAktInd("aktivitet",0);

	assertEquals(arbejdsdag.findAktInd("aktivitet", 0), arbejdsdag.findAktInd("aktivitet", 0));		}
	
	
}
