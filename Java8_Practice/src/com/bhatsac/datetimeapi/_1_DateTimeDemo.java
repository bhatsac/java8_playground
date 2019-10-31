package com.bhatsac.datetimeapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;
/**
 * 
 * @author bhatsac
 *Introduced as part of Java8 version
 *new package java.time.* package
 *based on joda.org project.
 *
 */
public class _1_DateTimeDemo {

	public static void main(String[] args) {
		// This to get the local Data 
		LocalDate ld=LocalDate.now();
		System.out.println(ld);
		
		//This is to get the local time 
		LocalTime lt=LocalTime.now();
		System.out.println(lt);
		
		
		
		// This to get the local Data and format as per our needs 
		LocalDate ldf=LocalDate.now();
		
		
		System.out.println(ldf.getDayOfMonth());
		System.out.println(ldf.getMonthValue());
		System.out.println(ldf.getYear());
		
		
		//This is to get the local time 
		LocalTime ltf=LocalTime.now();
		System.out.println(ltf.getHour());
		System.out.println(ltf.getMinute());
		System.out.println(ltf.getSecond());
		System.out.println(ltf.getNano());
		System.out.println(ltf.NOON);
				
		// Both together
		LocalDateTime ldt =LocalDateTime.now();
		System.out.println(ldt.getYear());
		System.out.println(ldt.getChronology());
		
		// Both together formatted
		LocalDateTime ldtf=LocalDateTime.of(1987, Month.MAY, 25, 19, 31);
		System.out.println(ldtf.plusDays(10000));  // when did i complete 10000 days since my birth.
		System.out.println(ldtf);

		
		// Period class
		LocalDate ldtp=LocalDate.of(1987, Month.MAY, 25);
		LocalDate ldtpnow=LocalDate.now();
		Period between = Period.between(ldtp, ldtpnow);
		System.out.println(between.getYears()+"years, "+between.getMonths()+"months, "+between.getDays()+"days as of today.");// my age as of today
		
		//zones, zoneid, zonedatetime
		ZoneId zid=ZoneId.systemDefault();// system default zone
		System.out.println(zid);
		Set<String> availableZoneIds = zid.getAvailableZoneIds();  // all avialbel zones
		for (String zones : availableZoneIds) {
			System.out.println(zones);
		}
		
		ZoneId zidIceland=ZoneId.of("Iceland");
		ZonedDateTime zdtime=ZonedDateTime.now(zidIceland);
		System.out.println(zdtime);
		
		
		
	}
}
