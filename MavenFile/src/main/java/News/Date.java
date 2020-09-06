package News;

import java.util.ArrayList;

import javax.swing.text.MaskFormatter;

public class Date {

	public ArrayList<String> date(String date1, String date2) {
		ArrayList<String> d = new ArrayList<String>();
		int year1 = Integer.parseInt(date1.substring(0, 4));
		int month1 = Integer.parseInt(date1.substring(4, 6));
		int day1 = Integer.parseInt(date1.substring(6));
		int year2 = Integer.parseInt(date2.substring(0, 4));
		int month2 = Integer.parseInt(date2.substring(4, 6));
		int day2 = Integer.parseInt(date2.substring(6));
		int lastday;
		d.add(date1);
		while (true) {
			
			if (month1 == 2) {
				lastday = 28;
				if (year1 % 4 == 0 && year1 % 100 != 0 || year1 % 400 == 0)
					lastday = 29;
				else
					lastday = 28;
			} else {
				if (month1 == 4 || month1 == 6 || month1 == 9 || month1 == 11)
					lastday = 30;
				else
					lastday = 31;
			}
// ---------------------------------------------------------------------------------- //
			if (year1 != year2 || month1 != month2 || day1 != day2) {
				day1 += 1;
				if (day1 > lastday) {
					day1 = 1;
					month1 += 1;
				} else if (month1 == 13) {
					month1 = 1;
					year1 += 1;
				}
				if (day1 < 10 && month1 < 10)
					d.add(Integer.toString(year1) + "0" + Integer.toString(month1) + "0" + Integer.toString(day1));
				else if (day1 >= 10 && month1 < 10)
					d.add(Integer.toString(year1) + "0" + Integer.toString(month1) + Integer.toString(day1));
				else if (day1 < 10 && month1 >= 10)
					d.add(Integer.toString(year1) + Integer.toString(month1) + "0" + Integer.toString(day1));
				else
					d.add(Integer.toString(year1) + Integer.toString(month1) + Integer.toString(day1));
			}
			else break;
		}
		return d;
	}
}