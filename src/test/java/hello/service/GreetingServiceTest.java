package hello.service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class GreetingServiceTest {

	GreetingService service;
	Calendar calendar;

	@Before
	public void init() {
		service = new GreetingService();
		calendar = Calendar.getInstance();
	}

	@Test
	public void testThatGreetingMethodReturnsMorningWhenTheTOfTheDayIsBetween12AMAnd12PM() throws Exception {
		checkExpectations(10, "Morning");
	}

	@Test
	public void testThatGreetingMethodReturnsAfternoonWhenTheTimeOfTheDayIsBetween12PMAnd5PM() throws Exception {
		checkExpectations(13, "Afternoon");
	}

	@Test
	public void testThatGreetingMethodReturnsEveningWhenTheTimeOfTheDayIsBetween5PMAnd8PM() throws Exception {
		checkExpectations(18, "Evening");
	}
	
	@Test
	public void testThatGreetingMethodReturnsNightWhenTheTimeOfTheDayIsBetween8PMAnd12AM() throws Exception {
		checkExpectations(21, "Night");
	}
	
	@Test
	public void testThatGreetingMethodReturnsAfternoonWhenTheTimeOfTheDayIs5PM() throws Exception {
		checkExpectations(17, "Afternoon");
	}

	private void checkExpectations(int hour, String expectation) {
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		String greeting = service.checkTimeForGreeting(calendar.getTime());
		assertThat(greeting, is(expectation));
	}
}
