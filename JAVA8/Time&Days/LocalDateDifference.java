import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.ChronoUnit;

public class LocalDateDifference {

//to find no of days btw star & end date
    public static void calDaysDifference(LocalDate startDate, LocalDate endDate){
        long difference=ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("No of days between " + startDate + " and " + endDate + " are " + difference);//to find no of days btw two dates
    }

//to fing age  
    public static void findAge(LocalDate startDate, LocalDate endDate){
        Period period=Period.between(startDate, endDate);
        System.out.println("Age: " + period.getYears() + " years, " + period.getMonths() + " months, " + period.getDays() + " days");
    }

//to find nxt sat or any day from start date
    public static void findNextDay(LocalDate startDate, DayOfWeek day){
        LocalDate nextDay=startDate.with(TemporalAdjusters.next(day)); //check for any day
        System.out.println("Next " + day + " from " + startDate + " is : " + nextDay); 
    }

//to count no of saturday or any specific day btw 2 days
    public static void CountNoOfDay(LocalDate startDate, LocalDate endDate, DayOfWeek day){
        long countNoOfDays=0;
        while(!startDate.isAfter(endDate)){
            if(startDate.getDayOfWeek()==day){
                countNoOfDays++;
            }
            startDate = startDate.plusDays(1); 
        }
        System.out.println("No of " + day + "'s between " + startDate + " and " + endDate + " are " + countNoOfDays);
    }

//want to find the days of start and end for a specific month. like from which day this month will start

public static void calculateDifference(LocalDate startDate){
    LocalDate first=startDate.with(TemporalAdjusters.firstDayOfMonth());
    DayOfWeek dayOFLocalDate=first.getDayOfWeek();

    LocalDate last=startDate.with(TemporalAdjusters.lastDayOfMonth());
    DayOfWeek dayOFLocalDatelast=last.getDayOfWeek();

    System.out.println("First Day of Month: " + dayOFLocalDate + " & Last Day of Month: " + dayOFLocalDatelast);
}

    public static void main(String[] args) {

        LocalDate startDate=LocalDate.of(2025, 3, 01);
        LocalDate endDate=LocalDate.of(2025, 4, 1);
        //LocalDate endDate=LocalDate.now();
        System.out.println();

        calDaysDifference(startDate, endDate);
        System.out.println();

        findAge(startDate, endDate);
        System.out.println();

        findNextDay(startDate, DayOfWeek.MONDAY);
        System.out.println();

        calculateDifference(startDate);
        System.out.println();

        CountNoOfDay(startDate, endDate,DayOfWeek.THURSDAY);
        System.out.println();
    }
}
