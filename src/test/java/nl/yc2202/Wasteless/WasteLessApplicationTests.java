package nl.yc2202.Wasteless;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

import nl.yc2202.Wasteless.domein.Appointment;

@SpringBootTest
public class WasteLessApplicationTests {

	@Test
	void contextLoads() {
		Assertions.assertEquals(1,1);
		Appointment ap = new Appointment();
		ap.setAdres("Vlakbij 3");
		Assertions.assertEquals("Vlakbij", ap.getAdres());
		
	}

}