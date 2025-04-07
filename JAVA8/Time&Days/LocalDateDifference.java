import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.ChronoUnit;

public class LocalDateDifference {
    public static long calculateDifference(LocalDate startDate, LocalDate endDate){

//to fing age    
    //Period period=Period.between(startDate, endDate);
    //System.out.println("Age: " + period.getYears() + " years, " + period.getMonths() + " months, " + period.getDays() + " days");

//to find nxt sat or any day from start date
    //LocalDate nextSaturday=startDate.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
    //System.out.println(nextSaturday);

//to count no of saturday or any specific day btw 2 days
    //long countNoOfSat=0;
    //while(!startDate.isAfter(endDate)){
    //    if(startDate.getDayOfWeek()==DayOfWeek.SATURDAY){
    //        countNoOfSat++;
    //    }
    //    startDate = startDate.plusDays(1); 
    //}
    //return countNoOfSat;


//want to find the days of start and end for a specific month. like from which day this month will start
//public static void calculateDifference(LocalDate startDate){
    //LocalDate first=startDate.with(TemporalAdjusters.firstDayOfMonth());
    //DayOfWeek dayOFLocalDate=first.getDayOfWeek();
    //LocalDate last=startDate.with(TemporalAdjusters.lastDayOfMonth());
    //DayOfWeek dayOFLocalDatelast=last.getDayOfWeek();
    //System.out.println("First Day of Month: " + dayOFLocalDate + " & Last Day of Month: " + dayOFLocalDatelast);


//to find no of days btw star & end date
    return ChronoUnit.DAYS.between(startDate, endDate);//to find no of days btw two dates
    }

    public static void main(String[] args) {
        LocalDate startDate=LocalDate.of(2025, 5, 01);
        LocalDate endDate=LocalDate.now();
        
        //LocalDate endDate=LocalDate.of(2025, 04, 07);
        //calculateDifference(startDate);

        System.out.println(calculateDifference(startDate, endDate));
    }

}
