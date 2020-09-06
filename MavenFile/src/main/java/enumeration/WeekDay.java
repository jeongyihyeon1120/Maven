package enumeration;

import java.util.Calendar;
public class WeekDay {
    enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }
    
    public static void main(String args[]) {
        Day day;
        Calendar c = Calendar.getInstance();
        int value = c.get(Calendar.DAY_OF_WEEK);    //  Calendar.DAY_OF_WEEK 값이 1부터 SUNDAY, 2는 MONDAY...
        switch(value) {
            case 1:
                day = Day.SUNDAY;
                break;
            case 2:
                day = Day.MONDAY;
                break;
            case 3:
                day = Day.TUESDAY;
                break;
            case 4:
                day = Day.WEDNESDAY;
                break;
            case 5:
                day = Day.THURSDAY;
                break;              
            case 6:
                day = Day.FRIDAY;
                break;
            default:
                day = Day.SATURDAY;
                break;
        }
        System.out.println(day);
    }
}