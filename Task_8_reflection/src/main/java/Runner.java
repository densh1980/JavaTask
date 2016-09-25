/**
 * Created by densh on 25.09.2016.
 */
import decompiler.ClassAnalyzer;
import  target.ScheduledEvent;

import java.util.Objects;

public class Runner {

    public static void main(String[] args) {
        System.out.println("I. Sub task 1 ");
        ScheduledEvent ev =  new ScheduledEvent();
        ev.setEventName("English lesson")
                .setClassroom("104")
                .setDate("2016-09-30 12:00");
        System.out.println(ev.getTimeBeforeEvent());
        System.out.println(ev.toString());

        System.out.println("\n II. Sub task 2 ");
        System.out.println("__________________________");

        ClassAnalyzer ca = new ClassAnalyzer(ev);
        ca.callBlackLabelAnotatedMethods();

        System.out.println("\n III. Sub task 3 ");
        System.out.println("__________________________");
        ca.printAnnotatedMethodsAndParams();

        System.out.println("IV. Sub task 4 ");
        System.out.println("__________________________");
        System.out.println(ca.getSuperClassName());
    }
}
