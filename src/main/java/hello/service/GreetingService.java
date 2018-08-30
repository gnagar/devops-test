package hello.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

	public String checkTimeForGreeting(Date timeOfGreeting) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(timeOfGreeting);

		if (calendar.get(Calendar.HOUR_OF_DAY) > 12 && calendar.get(Calendar.HOUR_OF_DAY) < 17) {
			return "Afternoon";
		} else if (calendar.get(Calendar.HOUR_OF_DAY) > 17 && calendar.get(Calendar.HOUR_OF_DAY) < 20) {
			return "Evening";
		} else if (hourBetween20And23(calendar)) {
			return "Night";
		} else {
			return "Morning";
		}
	}

	private boolean hourBetween20And23(Calendar calendar) {
		return calendar.get(Calendar.HOUR_OF_DAY) > 20 && calendar.get(Calendar.HOUR_OF_DAY) <= 23;
	}

}
