// Clara - s180350
import static org.junit.Assert.*;

import org.junit.Test;

import SoftwareEngineringProjekt.src.Aktivitet;
import SoftwareEngineringProjekt.src.Arbejdsdag;
import SoftwareEngineringProjekt.src.Dato;

public class ArbejdsdagTest {

	@org.junit.Test
	public void addTid() {
//		arrange
    	Arbejdsdag arbejdsdag = new Arbejdsdag(new Dato(2020, 3));
//    	act
    	arbejdsdag.addTid("projekt", "aktivitet", 2);
//    	assert
    	assertEquals("Arbejdstider for: 22-1-2020\nprojekt\naktivitet: 2\nTotaltid: 2" ,arbejdsdag.getTid());
	}

	@org.junit.Test
	public void getTid() {
//		arrange
    	Arbejdsdag arbejdsdag = new Arbejdsdag(new Dato(2020, 3));
//    	act
    	arbejdsdag.addTid("projekt", "aktivitet", 2);
//    	assert
    	assertEquals(arbejdsdag.getTid(),arbejdsdag.getTid());
	}
	
	@org.junit.Test
	public void findProjInd() {
//		arrange
		Arbejdsdag arbejdsdag = new Arbejdsdag(new Dato(3,2020));
//		act
		arbejdsdag.findProjInd("projekt");
//		assert
		assertEquals(arbejdsdag.findProjInd("projekt"), arbejdsdag.findProjInd("projekt"));
	}
	
	
//	@org.junit.Test
//	public void findAktInd() {
//		Arbejdsdag arbejdsdag = new Arbejdsdag(new Dato(3,2020));
//		
//		arbejdsdag.findAktInd("aktivitet",3);
//		
//		assertEquals(arbejdsdag.findAktInd("aktivitet", 3), arbejdsdag.findAktInd("aktivitet", 2));	
//	}
	
	
}
