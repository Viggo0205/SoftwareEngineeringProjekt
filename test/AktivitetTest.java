
import io.cucumber.java.en.Given;
//import junit.framework.Assert;

import static org.junit.Assert.*;
import static org.junit.Test.*;

import SoftwareEngineringProjekt.src.Aktivitet;
import SoftwareEngineringProjekt.src.Dato;
import SoftwareEngineringProjekt.src.Medarbejder;

public class AktivitetTest {

//	Aktivitet aktivitet = new Aktivitet("Aktivitet 1", new Dato(2020, 2), new Dato(2020, 3), 6);
	
//    @Given("RegistrerTimer")
	
	@org.junit.Test
    public void addTid() {
    	
    	// Arrrange
    	Aktivitet aktivitet = new Aktivitet("Aktivitet 1", new Dato(2020, 2), new Dato(2020, 3), 6);
    	
    	// Act
    	aktivitet.addTid(3);
    	
    	// Assert
    	assertEquals(3, aktivitet.getTime());
    	
    	
//    	String expectedResult = "hej";
//    	
//    	String actualResult = aktivitet.getAllData();
//    	Assert.assertEquals(expectedResult, actualResult);
    }

    @org.junit.Test
    public void addMedarbejder() {
    	
    	// Arrange
    	Aktivitet aktivitet = new Aktivitet("Aktivitet 1", new Dato(2020, 2), new Dato(2020, 3), 6);
    	
    	// Act
    	aktivitet.addMedarbejder(new Medarbejder("TEST", 1));
    	
    	// Assert
    	assertEquals("Medarbejdere:\nTEST", aktivitet.getMedarbejdere());
    }

    @org.junit.Test
    public void getAllData() {
    }

    @org.junit.Test
    public void getNavn() {
    }

    @org.junit.Test
    public void setStartUge() {
    }

    @org.junit.Test
    public void getStartUge() {
    }

    @org.junit.Test
    public void getSlutUge() {
    }

    @org.junit.Test
    public void setSlutUge() {
    }
}