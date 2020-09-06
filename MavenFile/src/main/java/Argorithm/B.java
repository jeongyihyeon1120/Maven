package Argorithm;

import java.security.acl.LastOwnerException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.crypto.SealedObject;
import javax.swing.text.TabableView;

import lombok.ToString;

public class B {

	public static int totalDayFromCalendar(int year, int month, int day) {
		ArrayList dayofMonth = new ArrayList(Arrays.asList(31,28,31,30,31,30,31,31,30,31,30));
		int i = 1;
		int totaldays = 365 * (year - 1);
		while (i < year) {
			if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
				totaldays += 1;				
			}
			i++;
		}
		int premonth = month -1;
		for (int j = 0; j < dayofMonth.size(); j++) {
			if (premonth >= j + 1) {
				totaldays = totaldays + (int)dayofMonth.get(j);		
		}
		if (month > 2 && year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			totaldays ++;
		}
		totaldays ++;
		totaldays = totaldays + day;
	}
		return totaldays + 1;		
}
	
	public static int endDayFromTotalDay(int year, int month) {
		int lastday;
		if (month == 2){
			lastday = 28;
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) lastday = 29;
			else lastday = 28;
		}
		else {
			if (month == 4 || month == 6 || month == 9 || month == 11) lastday = 30;				
			else lastday = 31;
		}
		return lastday;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("년도 입력");
		Scanner s = new Scanner(System.in);
		int year = s.nextInt();
		System.out.println("월 입력");
		int month = s.nextInt();
	
		int last_day = endDayFromTotalDay(year, month);
		System.out.println(last_day);
		int day = totalDayFromCalendar(year,month,last_day);
		int start_day = totalDayFromCalendar(year,month,1) % 7;
		System.out.println(start_day);
		
		int a = 0;
		int d = 0;
		
		System.out.println("-----"+year+"년"+month+"월"+"-----");
		
		for (int i = 0; i < 6; i++) {
			for (int j = 1; j < 8; j++) {
				if (i == 0 && a == 0 && start_day - 1 > 0) {
					System.out.print(" " + "  ");
					start_day -= 1;
					continue;
				}
				a = 1;
				d ++;
				if (d > last_day) {
					System.out.print(" " + "  ");
					continue;
				}
				if (d >= 10) {
					System.out.print(d + " ");
				}
				else {
					System.out.print(d + "  ");
				}
			}
			System.out.println();
		}
		s.close();
	}	
}