
import io.cucumber.java.en.Given;
//import junit.framework.Assert;

import static org.junit.Assert.*;
import static org.junit.Test.*;

import org.junit.Assert;

import SoftwareEngineringProjekt.src.Aktivitet;
import SoftwareEngineringProjekt.src.Dato;
import SoftwareEngineringProjekt.src.Medarbejder;

public class AktivitetTest {

//	Aktivitet aktivitet = new Aktivitet("Aktivitet 1", new Dato(2020, 2), new Dato(2020, 3), 6);
	
//    @Given("RegistrerTimer")
	
	@org.junit.Test
	@Given("test123") 
    public void addTid() {
    	
    	// Arrange
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
    	// Arrange
    	Aktivitet aktivitet = new Aktivitet("Aktivitet 1", new Dato(2, 2020), new Dato(5, 2020), 6);
    	
    	// Act
    	aktivitet.addMedarbejder(new Medarbejder("TEST", 1));
    	
    	// Assert
    	assertEquals("Aktivitets navn: Aktivitet 1\nstartuge: 2\nslutuge: 5\nbudgettid: 6\nrealtid: 0\nmedarbejdere:\nTEST", aktivitet.getAllData());
    }
    
    @org.junit.Test
    public void getAllData2() {
    	// Arrange
    	Aktivitet aktivitet = new Aktivitet("Aktivitet 1", new Dato(2, 2020), new Dato(5, 2020), 6);
    	
    	// Act
    	aktivitet.addTid(3);
    	
    	// Assert
    	assertEquals("Aktivitets navn: Aktivitet 1\nstartuge: 2\nslutuge: 5\nbudgettid: 6\nrealtid: 3\nmedarbejdere:", aktivitet.getAllData());
    }

    @org.junit.Test
    public void getNavn() {
    	// Arrange
    	Aktivitet aktivitet = new Aktivitet("Aktivitet 1", new Dato(2, 2020), new Dato(5, 2020), 6);
    	
    	//Act
    	
    	// Assert
    	assertEquals("Aktivitet 1",aktivitet.getNavn());
    }

    @org.junit.Test
    public void setStartUge() {
    	// Arrange
    	Aktivitet aktivitet = new Aktivitet("Aktivitet 1", new Dato(2, 2020), new Dato(5, 2020), 6);
    	
    	// Act
    	aktivitet.setStartUge(3, 2020);
    	
    	// Assert
    	assertArrayEquals(new int[]{3, 2020}, aktivitet.getStartUge());
    }

    @org.junit.Test
    public void getStartUge() {
    	// Arrange
    	Aktivitet aktivitet = new Aktivitet("Aktivitet 1", new Dato(2, 2020), new Dato(5, 2020), 6);
    	
    	// Assert
    	assertArrayEquals(new int[]{2, 2020}, aktivitet.getStartUge());
    }

    @org.junit.Test
    public void getSlutUge() {
    	// Arrange
    	Aktivitet aktivitet = new Aktivitet("Aktivitet 1", new Dato(2, 2020), new Dato(5, 2020), 6);
    	
    	// Assert
    	assertArrayEquals(new int[]{5, 2020}, aktivitet.getSlutUge());
    }

    @org.junit.Test
    public void setSlutUge() {
    	// Arrange
    	Aktivitet aktivitet = new Aktivitet("Aktivitet 1", new Dato(2, 2020), new Dato(5, 2020), 6);
    	
    	// Act
    	aktivitet.setSlutUge(6, 2020);
    	
    	// Assert
    	assertArrayEquals(new int[]{6, 2020}, aktivitet.getSlutUge());
    }
}