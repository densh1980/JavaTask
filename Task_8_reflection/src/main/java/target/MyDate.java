package target;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class MyDate {


    public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    private  LocalDateTime date;

    public MyDate(){
        this.date = LocalDateTime.now();
    }

    /**  Init date from string
     * @param dateStr  date in format  "yyyy-MM-dd HH:mm"
     * */
    public MyDate(String dateStr){
        if(!tryParse(dateStr)) date = LocalDateTime.now();
    }

    public MyDate(LocalDateTime date){
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    /**  set date from string
     * @param dateStr  date in format  "yyyy-MM-dd HH:mm"
     * */
    public void setDate(String dateStr){
        if(!tryParse(dateStr)) date = LocalDateTime.now();
    }

    private boolean tryParse(String dateStr){
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM);
         try {

             date = LocalDateTime.parse(dateStr, formatter);
             return true;
         } catch (DateTimeParseException e) {
             return false;
         }

     }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM);
        return date.format(formatter);
    }
}
