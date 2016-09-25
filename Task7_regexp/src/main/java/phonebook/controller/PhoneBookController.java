package phonebook.controller;

import phonebook.model.Address;
import phonebook.model.CallerGroup;
import phonebook.model.PhoneBookRecord;
import phonebook.view.PhoneBookView;

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
    //phone or empty string;
    public static final String PHONE_PATTERN_NA = "^(\\+\\d{1,3}[- ]?)?\\d{10}$|^$";



    public static final String LAST_NAME_MSG = "Фамилия абонента";
    public static final String FIRST_NAME_MSG = "Имя абонента";
    public static final String MIDDLE_NAME_MSG = "Отчество абонента";
    public static final String NICK_NAME_MSG = "Никнейм";
    public static final String DESCRIPTION = "Комментарий";
    public static final String ENTER_GROUP_MSG = "Группы в которую занесен абонент :FAMILY|FRIENDS|WORK|EMERGENCY";
    public static final String PHONE_MSG = "Телефон домашний : +38-YYYXXXXXXX или YYYXXXXXXX   ";
    public static final String MOBILE_PHONE_MSG = "Телефон мобильный.";
    public static final String MOBILE_PHONE2_MSG = "Телефон мобильный.2";
    public static final String EMAIL_MSG = "email :";
    public static final String SKYPE_MSG = "skype";
    public static final String ADDRESS_MSG = "Адрес : индекс,город,улица,номер";


    PhoneBookRecord record;
    PhoneBookView view;
    Scanner sc =  new Scanner(System.in);

    // controller init
    public PhoneBookController(PhoneBookRecord record,PhoneBookView view){
        this.record = record;
        this.view = view;
    }

    // The App main loop

    public void run(){
        String input;
        do {
            view.showInputMsg(LAST_NAME_MSG);
            input = getInputValue();
        } while (!validate(input, TEXT_PATTERN));
        record.setFirstName(input);

        do {
            view.showInputMsg(FIRST_NAME_MSG);
            input = getInputValue();
        } while (!validate(input, TEXT_PATTERN));
        record.setLastName(input);

        do {
            view.showInputMsg(MIDDLE_NAME_MSG);
            input = getInputValue();
        } while (!validate(input, TEXT_PATTERN));
        record.setMiddleName(input);
        do {
            view.showInputMsg(NICK_NAME_MSG);
            input = getInputValue();
        } while (!validate(input, TEXT_PATTERN));
        record.setNickName(input);

        do {
            view.showInputMsg(DESCRIPTION);
            input = getInputValue();
        } while (!validate(input, TEXT_PATTERN));
        record.setDescription(input);


        do {
            view.showInputMsg(ENTER_GROUP_MSG);
            input = getInputValue();
        } while (!validate(input, CALLER_GROUP_TEMPLATE));
        record.setCallerGroup(CallerGroup.valueOf(input));

        do {
            view.showInputMsg(PHONE_MSG);
            input = getInputValue();
        } while (!validate(input, PHONE_PATTERN));
        record.setHomePhone(input);

        do {
            view.showInputMsg(MOBILE_PHONE_MSG);
            input = getInputValue();
        } while (!validate(input, PHONE_PATTERN_NA));
        record.setPrimaryMobPhone(input);

        do {
            view.showInputMsg(MOBILE_PHONE2_MSG);
            input = getInputValue();
        } while (!validate(input, PHONE_PATTERN_NA));
        record.setSecondaryMobPhone(input);

        do {
            view.showInputMsg(EMAIL_MSG);
            input = getInputValue();
        } while (!validate(input, EMAIL_PATTERN));
        record.setEmail(input);

        do {
            view.showInputMsg(SKYPE_MSG);
            input = getInputValue();
        } while (!validate(input, TEXT_PATTERN));
        record.setSkype(input);

        do {
            view.showInputMsg(ADDRESS_MSG);
            input = getInputValue();
        } while (!validate(input, ADDRESS_PATTERN));
        record.setAddress(new Address(input));


    };

    // The Utility methods

    public  boolean validate(String input,String pattern){
        if(input.matches(pattern)) return true;
        return false;
    }
    public  String getInputValue(){

        return sc.nextLine();
    }


}
