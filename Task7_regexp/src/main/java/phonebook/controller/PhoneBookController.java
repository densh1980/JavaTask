package phonebook.controller;

import phonebook.model.Address;
import phonebook.model.CallerGroup;
import phonebook.model.PhoneBookRecord;

import java.util.Scanner;

/**
 * Created by Denys_Shmyhin on 9/20/2016.
 */

public class PhoneBookController {
    public static final String TEXT_PATTERN = "^[a-z A-Z 0-9]{1,60}";
    public static final String EMAIL_PATTERN = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
    public static final String CALLER_GROUP_TEMPLATE = "(FAMILY)|(FRIENDS)|(WORK)|(EMERGENCY)";
    public static final String ADDRESS_PATTERN = "^[1-9 ]{5,6}[,]+[a-zA-Z -]+[,][a-zA-Z0-9 ]+[,][0-9]{1,4}[a-zA-Z/0-9]*$";
    public static final String PHONE_PATTERN = "^(\\+\\d{1,3}[- ]?)?\\d{10}$";
    public static final String PHONE_PATTERN_NA = "^(\\+\\d{1,3}[- ]?)?\\d{10}$|^$";

    PhoneBookRecord record;
    Scanner sc =  new Scanner(System.in);


    public PhoneBookController(PhoneBookRecord record){
        this.record = record;
    }
    public void run(){
        String input;
        do {
            showInputMsg("Фамилия абонента");
            input = getInputValue();
        } while (!validate(input, TEXT_PATTERN));
        record.setFirstName(input);

        do {
            showInputMsg("Имя абонента");
            input = getInputValue();
        } while (!validate(input, TEXT_PATTERN));
        record.setLastName(input);

        do {
            showInputMsg("Отчество абонента");
            input = getInputValue();
        } while (!validate(input, TEXT_PATTERN));
        record.setMiddleName(input);
        do {
            showInputMsg("Никнейм");
            input = getInputValue();
        } while (!validate(input, TEXT_PATTERN));
        record.setNickName(input);

        do {
            showInputMsg("Комментарий");
            input = getInputValue();
        } while (!validate(input, TEXT_PATTERN));
        record.setDescription(input);


        do {
            showInputMsg("Группы в которую занесен абонент :FAMILY|FRIENDS|WORK|EMERGENCY");
            input = getInputValue();
        } while (!validate(input, CALLER_GROUP_TEMPLATE));
        record.setCallerGroup(CallerGroup.valueOf(input));

        do {
            showInputMsg("Телефон домашний : +38-YYYXXXXXXX или YYYXXXXXXX   ");
            input = getInputValue();
        } while (!validate(input, PHONE_PATTERN));
        record.setHomePhone(input);

        do {
            showInputMsg("Телефон мобильный.");
            input = getInputValue();
        } while (!validate(input, PHONE_PATTERN_NA));
        record.setPrimaryMobPhone(input);

        do {
            showInputMsg("Телефон мобильный.2");
            input = getInputValue();
        } while (!validate(input, PHONE_PATTERN_NA));
        record.setSeondaryMobPhone(input);

        do {
            showInputMsg("email :");
            input = getInputValue();
        } while (!validate(input, EMAIL_PATTERN));
        record.setEmail(input);

        do {
            showInputMsg("skype");
            input = getInputValue();
        } while (!validate(input, TEXT_PATTERN));
        record.setSkype(input);

        do {
            showInputMsg("Адрес : индекс,город,улица,номер");
            input = getInputValue();
        } while (!validate(input, ADDRESS_PATTERN));
        record.setAddress(new Address(input));


    };

    public  boolean validate(String input,String pattern){
        if(input.matches(pattern)) return true;
        return false;
    }
    public  String getInputValue(){

        return sc.nextLine();
    }

    public void showInputMsg(String field){
        System.out.println(field);
    }



}
