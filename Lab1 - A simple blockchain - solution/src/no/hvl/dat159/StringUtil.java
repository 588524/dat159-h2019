package no.hvl.dat159;

import java.time.Duration;

public class StringUtil {

	public static String truncated(String s, int length) {
		return s.length() <= length ? s : s.substring(0, length) + "...";
	}

	public static String formatDuration(Duration d) {
		int hours = d.toHoursPart();
		int minutes = d.toMinutesPart();
		int seconds = d.toSecondsPart();
		int millis = d.toMillisPart();
		
		if (hours != 0) {
			return String.format("%d hours, %d minutes and %d seconds", 
					hours, minutes, seconds);
		} else if (minutes != 0) {
			return String.format("%d minutes and %d.%03d seconds", 
					minutes, seconds, millis);
		} else {
			return String.format("%d.%03d seconds", 
					seconds, millis);
		}
	}
	
}
