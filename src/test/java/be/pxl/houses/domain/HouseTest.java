package be.pxl.houses.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class HouseTest {
    private House house;

    private Status status;
    @BeforeEach
    public void setUp() {
        house = new House("ABC123", "3-bedroom house", 250, EPCScore.B);

    }

    //getters testen
    @Test
    public void testGetDescription() {
        assertEquals("3-bedroom house", house.getDescription());
    }

    @Test
    public void testGetEpsScore() {
        assertEquals(EPCScore.B, house.getEpcScore());
    }

    @Test
    public void testGetCode(){
        assertEquals("ABC123", house.getCode());
    }

    @Test
    public void testGetArea(){
        assertEquals(250, house.getArea());
    }

    @Test
    public void testGetCity(){
        house.setCity("Hasselt");
        assertEquals("Hasselt", house.getCity());
    }


    @Test
    public void testGetPrice(){
        house.setCity("Hasselt");
        double price = house.getArea() * House.BASE_PRICE * house.getEpcScore().getPercentage();
        assertEquals(price * 1.25, house.getPrice());
        house.setCity("Antwerpen");
        assertEquals(price, house.getPrice());
    }

    // test for setters
    @Test
    public void testSetDescription(){
        house.setDescription("test");
        assertEquals("test", house.getDescription());
    }

    @Test
    public void testSetEpcScore() {
        house.setEpcScore(EPCScore.F);
        assertEquals(EPCScore.F, house.getEpcScore());
    }

    @Test
    public void testSetArea() {
        house.setArea(20);
        assertEquals(20, house.getArea());
    }

    @Test
    public void testSetCity() {
        house.setCity("Genk");
        assertEquals("Genk", house.getCity());
    }

    // test method
    @Test
    public void testMarkAsSold(){
        house.markAsSold();
        assertEquals(Status.SOLD,house.getStatus());
    }
    @Test
    public void testMarkAsSoldWhenAlreadySold(){
        house.markAsSold();
        assertThrows(IllegalStateException.class,()->house.markAsSold());
    }

}
