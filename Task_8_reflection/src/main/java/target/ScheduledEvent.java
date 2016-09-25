package target;

import decompiler.BlackLabel;
import decompiler.PrintParams;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class ScheduledEvent extends MyDate {

    private String eventName;
    private  String classroom;

    @PrintParams
    public String getEventName() {
        return eventName;
    }

    @BlackLabel
    @PrintParams
    public void doNothing(int a,float b,String c){};


    public ScheduledEvent setEventName(String eventName) {
        this.eventName = eventName;
        return this;
    }
    @BlackLabel
    public String getClassroom() {
        return classroom;
    }
    @PrintParams
    public ScheduledEvent setClassroom(String classroom) {
        this.classroom = classroom;
        return this;
    }

    @BlackLabel
    public String getTimeBeforeEvent(){
        ChronoUnit [] listOfUnits = {ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS,
                ChronoUnit.HOURS, ChronoUnit.MINUTES};
        LocalDateTime nowTime = LocalDateTime.now();
        LocalDateTime eventTime = getDate();
        if(nowTime.isAfter(eventTime)) return "Event expired";
        StringBuilder res = new StringBuilder("Time before event :");
        for (ChronoUnit unit:listOfUnits){
            long amount = nowTime.until(eventTime,unit);
            nowTime = nowTime.plus(amount,unit);
            if(amount != 0) res.append(amount)
                    .append("-")
                    .append(unit.toString())
                    .append(" ");
        };
        return  res.toString();

    }

    @PrintParams
    @Override
    public String toString() {
        return "ScheduledEvent{" +
                "eventName = " + eventName +
                ", classroom = " + classroom +
                ",time = " + super.toString()+
                '}';
    }
}
