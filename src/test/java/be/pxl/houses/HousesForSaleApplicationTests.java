package be.pxl.houses;

import be.pxl.houses.domain.EPCScore;
import be.pxl.houses.domain.House;
import be.pxl.houses.domain.Status;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class HousesForSaleApplicationTests {

	private House house;

	private Status status;
	@Test
	void contextLoads() {
	}

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
	public void testMarkAsSold() {
		house.markAsSold();
		assertEquals(Status.SOLD, house.getStatus());
		IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
			house.markAsSold();  // try to sell it again => exception
		});
		assertEquals("House is already marked as sold.", exception.getMessage());
	}


}
